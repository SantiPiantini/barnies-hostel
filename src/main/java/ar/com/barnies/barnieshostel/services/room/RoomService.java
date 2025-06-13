package ar.com.barnies.barnieshostel.services.room;

import java.util.List;

import ar.com.barnies.barnieshostel.models.room.Room;

public interface RoomService {
    public void createRoom(Room room);
    public void deleteRoom(Integer roomId);
    public void updateRoom(Room room);
    public Room getRoomById(Integer id) throws Exception;
    public List<Room> getAllRooms();
    
}
