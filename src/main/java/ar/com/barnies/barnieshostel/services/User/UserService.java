package ar.com.barnies.barnieshostel.services.User;


import ar.com.barnies.barnieshostel.models.User.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);
    public User getUserById(Integer id) throws Exception;
    public List<User> getAllUsers();
    public void deleteUser(Integer id);
    public void updateUser(User user) throws Exception;;
}
