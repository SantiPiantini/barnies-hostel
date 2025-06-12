package ar.com.barnies.barnieshostel.repository.Reserve;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SpringReserveRepository extends JpaRepository<Reserve, Integer> {

    @Query("SELECT r FROM Reserve r WHERE r.roomId = :roomId AND " +
            "(:checkInDate < r.checkOutDate AND :checkOutDate > r.checkInDate)")
    List<Reserve> findConflictingReserves(
            @Param("roomId") Integer roomId,
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate
    );
}
