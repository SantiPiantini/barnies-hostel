package repository.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Room.Room;

public interface  SpringRoomRepository extends JpaRepository<Room, Integer> {
    
    
    
}
