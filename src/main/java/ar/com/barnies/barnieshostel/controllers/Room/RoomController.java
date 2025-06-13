package ar.com.barnies.barnieshostel.controllers.Room;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.barnies.barnieshostel.models.room.Room;
import ar.com.barnies.barnieshostel.services.room.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody Room room) {
        roomService.createRoom(room);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable Integer id) throws Exception {
        Room room = roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }

    @GetMapping()
    public ResponseEntity<List<Room>> getAll() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Room room) {
        roomService.updateRoom(room);
        return ResponseEntity.noContent().build();
    }
}