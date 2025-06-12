package repository.Room;

import models.Room.Room;
import services.Room.RoomRepository;

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
