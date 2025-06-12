package services.Room;

import models.Room.Room;

import java.util.List;

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
    public void updateRoom(Room room) {
        roomServiceRepo.updateRoom(room);
    }
}
