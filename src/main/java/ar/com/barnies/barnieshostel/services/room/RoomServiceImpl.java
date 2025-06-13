package ar.com.barnies.barnieshostel.services.room;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import ar.com.barnies.barnieshostel.models.room.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomServiceRepo;

    public RoomServiceImpl(RoomRepository roomServiceRepo) {
        this.roomServiceRepo = roomServiceRepo;
    }

    @Override
    public void createRoom(Room room) {
        roomServiceRepo.create(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomServiceRepo.getAllRooms();
    }

    @Override
    public Room getRoomById(Integer id) throws Exception {
        return roomServiceRepo.getRoomById(id);
    }

    @Override
    public void deleteRoom(Integer id) {
        roomServiceRepo.deleteRoom(id);
    }

    @Override
    public void updateRoom(Room room) throws Exception{
        Room existing = roomServiceRepo.getRoomById(room.getId());
        if (existing == null) {
            throw new RuntimeException("room does not exist");
        }

        if (room.getName() == null){
            room.setName(existing.getName());
        }

        if (room.getCapacity() == null){
            room.setCapacity(existing.getCapacity());
        }

        if (room.getStatus() == null){
            room.setStatus(existing.getStatus());
        }
        roomServiceRepo.updateRoom(room);
    }
}
