package ar.com.barnies.barnieshostel.repository.User;

import ar.com.barnies.barnieshostel.models.User.User;
import ar.com.barnies.barnieshostel.services.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getByID(Integer id) {
        return springUserRepository.findById(id);
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
