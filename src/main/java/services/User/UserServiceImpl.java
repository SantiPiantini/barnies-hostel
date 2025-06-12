package services.User;

import models.User.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        boolean exist = userRepository.getAll()
                .stream()
                .anyMatch(u -> u.getDni().equals(user.getDni()));
        if (exist) {
            throw new RuntimeException("User already exists");
        }
        userRepository.create(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getUserById(Integer id) throws Exception{
        return userRepository.getById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public void updateUser(User user) {
        User existing = userRepository.getById(user.getUserID());
        if (existing == null) {
            throw new RuntimeException("User does not exist");
        }
        userRepository.update(user);
        userRepository.update(user);
    }
}
