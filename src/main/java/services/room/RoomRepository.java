package services.Room;
import models.Room.Room;
import java.util.List;



public interface  RoomRepository {

    public void create(Room room);
    public Room getRoomById(Integer id) throws Exception;
    public void deleteRoom(Integer id);
    public void updateRoom(Room room);
    public List<Room> getAllRooms();
    
}
