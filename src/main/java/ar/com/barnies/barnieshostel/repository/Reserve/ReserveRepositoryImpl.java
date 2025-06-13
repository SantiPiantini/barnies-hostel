package ar.com.barnies.barnieshostel.repository.Reserve;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import org.springframework.stereotype.Service;
import ar.com.barnies.barnieshostel.services.Reserve.ReserveRepository;

import java.time.LocalDate;
import java.util.List;

@Service
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
        return springReserveRepository.findById(id).orElseThrow(() -> new Exception("id reserve not found"));
    }

    @Override
    public void delete(Integer id){
        springReserveRepository.deleteById(id);
    }

    @Override
    public void update(Reserve reserve) {
        springReserveRepository.save(reserve);
    }

    @Override
    public List<Reserve> findConflictingReserves(Integer roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        return springReserveRepository.findConflictingReserves(roomId, checkInDate, checkOutDate);
    }
}
