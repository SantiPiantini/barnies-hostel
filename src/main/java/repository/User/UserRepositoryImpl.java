package repository.User;

import models.User.User;
import services.User.UserRepository;

import java.util.List;

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

    public User getById(Integer id) throws Exception{
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
