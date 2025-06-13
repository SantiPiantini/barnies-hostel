package ar.com.barnies.barnieshostel.services.User;

import ar.com.barnies.barnieshostel.models.User.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        /*boolean exist = userRepository.getAll()
                .stream()
                .anyMatch(u -> u.getDni().equals(user.getDni()));
        if (exist) {
            throw new RuntimeException("User already exists");
        }*/
        userRepository.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getUserById(Integer id) throws Exception{
        return userRepository.getByID(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public void updateUser(User user) throws Exception {
        User existing = userRepository.getByID(user.getUserID());
        if (existing == null) {
            throw new RuntimeException("User does not exist");
        }
        userRepository.update(user);
        userRepository.update(user);
    }
}
