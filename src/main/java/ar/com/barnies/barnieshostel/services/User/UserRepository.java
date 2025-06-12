package users.User;

import models.User.User;
import java.util.List;

public interface UserRepository {
    public void create(User user);
    public User getByID(integer Id) throws Exception;
    public List<User> getAll();
    public void delete(Integer Id);
    public void update(User user);
}