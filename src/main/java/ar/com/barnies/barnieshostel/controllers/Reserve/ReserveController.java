package ar.com.barnies.barnieshostel.controllers.Reserve;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.barnies.barnieshostel.services.Reserve.ReserveService;

import java.util.List;

@RestController
@RequestMapping("/api/reserves")
public class ReserveController {
    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody Reserve reserve) throws Exception{
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
    public ResponseEntity<Reserve> update(@PathVariable Integer id ,@RequestBody Reserve reserve) throws Exception{
        reserve.setId(id);
        reserveService.updateReserve(reserve);

        return ResponseEntity.noContent().build();
    }
}
