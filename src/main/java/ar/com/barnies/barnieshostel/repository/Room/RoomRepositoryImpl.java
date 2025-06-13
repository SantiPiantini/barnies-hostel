package ar.com.barnies.barnieshostel.repository.Room;

import ar.com.barnies.barnieshostel.models.room.Room;
import ar.com.barnies.barnieshostel.services.room.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomRepositoryImpl  implements RoomRepository {
    private final SpringRoomRepository springRoomRepository;

    public RoomRepositoryImpl(SpringRoomRepository springRoomRepository) {
        this.springRoomRepository = springRoomRepository;
    }

    @Override
    public void create(Room room) {
        springRoomRepository.save(room);
    }

    @Override
    public Room getRoomById(Integer id){
        return springRoomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
    }

    @Override
    public void deleteRoom(Integer id) {
        springRoomRepository.deleteById(id);
    }

    @Override
    public void updateRoom(Room room) {
        springRoomRepository.save(room);
    }

    @Override
    public java.util.List<Room> getAllRooms() {
        return springRoomRepository.findAll();
    }
    

}
