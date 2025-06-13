package ar.com.barnies.barnieshostel.services.room;
import ar.com.barnies.barnieshostel.exceptions.RoomAlreadyExistsException;
import ar.com.barnies.barnieshostel.exceptions.RoomNotFoundException;
import ar.com.barnies.barnieshostel.models.room.Room;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void createRoom(Room room) {
        boolean exists = roomRepository.getAllRooms().stream()
                .anyMatch(r -> r.getId().equals(room.getId()));

        if (exists) {
            throw new RoomAlreadyExistsException("La habitación con ID " + room.getId() + " ya existe.");
        }

        roomRepository.create(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public Room getRoomById(Integer id) throws Exception {
        Room room = roomRepository.getRoomById(id);
        if (room == null) {
            throw new RoomNotFoundException("Habitación con ID " + id + " no encontrada.");
        }
        return room;
    }

    @Override
    public void deleteRoom(Integer id) {
        try {
            Room room = roomRepository.getRoomById(id);
            if (room == null) {
            throw new RoomNotFoundException("Habitación con ID " + id + " no encontrada.");
        }
            roomRepository.deleteRoom(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la habitación con ID " + id, e);
        }
    }


    @Override
    public void updateRoom(Room room) throws Exception {
        Room existing = roomRepository.getRoomById(room.getId());
        if (existing == null) {
            throw new RoomNotFoundException("No se puede actualizar, la habitación no existe.");
        }

        if (room.getName() == null) {
            room.setName(existing.getName());
        }

        if (room.getCapacity() == null) {
            room.setCapacity(existing.getCapacity());
        }

        if (room.getStatus() == null) {
            room.setStatus(existing.getStatus());
        }

        if (room.getPrice() == 0){
            room.setPrice(existing.getPrice());
        }

        roomRepository.updateRoom(room);
    }
}
