package repository.Reserve;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Reserve.Reserve;

public interface SpringReserveRepository extends JpaRepository<Reserve, Integer> {

}
