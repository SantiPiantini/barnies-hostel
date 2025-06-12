package repository.Reserve;

import models.Reserve.Reserve;
import services.Reserve.ReserveRepository;

import java.util.List;

public class ReserveRepositoryImpl implements ReserveRepository {
    private final SpringReserveRepository springReserveRepository;

    public ReserveRepositoryImpl(SpringReserveRepository springReserveRepository) {
        this.springReserveRepository = springReserveRepository;
    }

    @Override
    public void create(Reserve reserve) {
        springReserveRepository.save(reserve);
    }

    @Override
    public List<Reserve> getAll() {
        return springReserveRepository.findAll();
    }

    @Override
    public Reserve getById(Integer id) throws Exception {
        return springReserveRepository.findById(id).orElseThrow(() -> new Exception("id not found"));
    }

    @Override
    public void delete(Integer id){
        springReserveRepository.deleteById(id);
    }

    @Override
    public void update(Reserve reserve) {
        springReserveRepository.save(reserve);
    }
}
