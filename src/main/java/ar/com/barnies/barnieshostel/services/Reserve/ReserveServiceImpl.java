package ar.com.barnies.barnieshostel.services.Reserve;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import ar.com.barnies.barnieshostel.models.User.User;
import ar.com.barnies.barnieshostel.models.room.Room;
import ar.com.barnies.barnieshostel.services.User.UserService;
import ar.com.barnies.barnieshostel.services.room.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService{

    private final ReserveRepository reserveRepository;
    private final UserService userService;
    private final RoomService roomService;

    public ReserveServiceImpl(ReserveRepository reserveRepository, UserService userService, RoomService roomService) {
        this.reserveRepository = reserveRepository;
        this.userService = userService;
        this.roomService = roomService;
    }

    @Override
    public void createReserve(Reserve reserve) throws Exception {

        User userExist = userService.getUserById(reserve.getUserId());
        Room roomExist = roomService.getRoomById(reserve.getRoomId());

        List<Reserve> reservesOccupated = reserveRepository.findConflictingReserves(reserve.getRoomId(), reserve.getCheckInDate(), reserve.getCheckOutDate());

        if (!reservesOccupated.isEmpty()){
            throw new Exception("room not disponible in that dates.");
        }
        reserveRepository.create(reserve);
    }

    @Override
    public List<Reserve> getAllReserves() {
        return reserveRepository.getAll();
    }

    @Override
    public Reserve getReserveById(Integer id) throws Exception{
        return reserveRepository.getById(id);
    }

    @Override
    public void deleteReserve(Integer id) {
        reserveRepository.delete(id);
    }

    @Override
    public void updateReserve(Reserve reserve) {
        reserveRepository.update(reserve);
    }
}
