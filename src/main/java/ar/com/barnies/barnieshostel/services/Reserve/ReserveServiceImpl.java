package ar.com.barnies.barnieshostel.services.Reserve;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService{

    private final ReserveRepository reserveRepository;

    public ReserveServiceImpl(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    @Override
    public void createReserve(Reserve reserve) {
        reserveRepository.create(reserve);
    }

    @Override
    public List<Reserve> getAllReserves() {
        return reserveRepository.getAll();
    }

    @Override
    public Reserve getReserveById(Integer id) throws Exception{
        return reserveRepository.getById(id);
    }

    @Override
    public void deleteReserve(Integer id) {
        reserveRepository.delete(id);
    }

    @Override
    public void updateReserve(Reserve reserve) {
        reserveRepository.update(reserve);
    }
}
