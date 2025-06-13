package ar.com.barnies.barnieshostel.services.User;


import ar.com.barnies.barnieshostel.models.User.User;

import java.util.List;

public interface UserRepository {
    public void create(User user);
    public User getByID(Integer Id) throws Exception;
    public List<User> getAll();
    public void delete(Integer Id);
    public void update(User user);
}