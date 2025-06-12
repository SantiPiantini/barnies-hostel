package repository.Reserve;

import models.Reserve.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringReserveRepository extends JpaRepository<Reserve, Integer> {

}
