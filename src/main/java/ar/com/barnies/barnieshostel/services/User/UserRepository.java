package ar.com.barnies.barnieshostel.services.User;


import ar.com.barnies.barnieshostel.models.User.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public void create(User user);
    Optional<User> getByID(Integer id);
    public List<User> getAll();
    public void delete(Integer Id);
    public void update(User user);
}