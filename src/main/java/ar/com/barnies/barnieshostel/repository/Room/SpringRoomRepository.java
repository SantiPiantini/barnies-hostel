package ar.com.barnies.barnieshostel.repository.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.barnies.barnieshostel.models.room.Room;

public interface  SpringRoomRepository extends JpaRepository<Room, Integer> {
    
    
    
}
