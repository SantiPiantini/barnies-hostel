package controllers.Reserve;

import models.Reserve.Reserve;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.Reserve.ReserveService;

import java.util.List;
import java.util.Optional;

public class ReserveController {
    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody Reserve reserve) {
        reserveService.createReserve(reserve);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserve> getById(@PathVariable Integer id) throws Exception{

        Reserve reserve = reserveService.getReserveById(id);

        return ResponseEntity.ok(reserve);
    }

    @GetMapping()
    public ResponseEntity<List<Reserve>> getAll(){

        List<Reserve> reserves = reserveService.getAllReserves();

        return ResponseEntity.ok(reserves);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        reserveService.deleteReserve(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserve> update(@RequestBody Reserve reserve){

        reserveService.updateReserve(reserve);

        return ResponseEntity.noContent().build();
    }
}
