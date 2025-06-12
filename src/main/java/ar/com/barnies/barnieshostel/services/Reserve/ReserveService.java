package ar.com.barnies.barnieshostel.services.Reserve;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;

import java.util.List;

public interface ReserveService {
    public void createReserve(Reserve reserve);
    public Reserve getReserveById(Integer id) throws Exception;
    public List<Reserve> getAllReserves();
    public void deleteReserve(Integer id);
    public void updateReserve(Reserve reserve);
}
