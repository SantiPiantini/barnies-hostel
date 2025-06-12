package services.User;

import models.User.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);
    public User getUserById(Integer id) throws Exception;
    public List<User> getAllUsers();
    public void deleteUser(Integer id);
    public void updateUser(User user);
}
