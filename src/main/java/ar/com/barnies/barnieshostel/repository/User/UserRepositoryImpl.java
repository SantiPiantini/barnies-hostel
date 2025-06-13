package ar.com.barnies.barnieshostel.repository.User;

import ar.com.barnies.barnieshostel.models.User.User;
import ar.com.barnies.barnieshostel.services.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {
    private final SpringUserRepository springUserRepository;

    public UserRepositoryImpl(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public void create (User user){
        springUserRepository.save(user);
    }

    @Override
    public List<User> getAll(){
        return springUserRepository.findAll();
    }

    public User getByID(Integer id) throws Exception{
        return springUserRepository.findById(id).orElseThrow(() -> new Exception("id not found"));
    }

    @Override
    public void delete(Integer id){
        springUserRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        springUserRepository.save(user);
    }
}
