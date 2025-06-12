package services.Reserve;

import models.Reserve.Reserve;

import java.util.List;

public interface ReserveRepository {
    public void create(Reserve reserve);
    public Reserve getById(Integer Id) throws Exception;
    public List<Reserve> getAll();
    public void delete(Integer id);
    public void update(Reserve reserve);
}
