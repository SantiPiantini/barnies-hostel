package ar.com.barnies.barnieshostel.services.User;

import ar.com.barnies.barnieshostel.exceptions.UserAlreadyExistsException;
import ar.com.barnies.barnieshostel.exceptions.UserNotFoundException;
import ar.com.barnies.barnieshostel.models.User.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        boolean exists = userRepository.getAll().stream()
                .anyMatch(u -> u.getDni().equals(user.getDni()));

        if (exists) {
            throw new UserAlreadyExistsException("El usuario con DNI " + user.getDni() + " ya existe.");
        }

        userRepository.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getByID(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario con ID " + id + " no encontrado."));
    }

    @Override
    public void deleteUser(Integer id) {
        if (userRepository.getByID(id).isEmpty()) {
            throw new UserNotFoundException("Usuario con ID " + id + " no encontrado.");
        }
        userRepository.delete(id);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> existing = userRepository.getByID(user.getUserID());
        if (existing.isEmpty()) {
            throw new UserNotFoundException("No se puede actualizar, el usuario no existe.");
        }

        if (user.getDni() == null) {
            user.setDni(existing.get().getDni());
        }

        if (user.getUsername() == null) {
            user.setUsername(existing.get().getUsername());
        }

        userRepository.update(user);
    }
}
