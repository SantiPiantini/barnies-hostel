package ar.com.barnies.barnieshostel.services.Reserve;

import ar.com.barnies.barnieshostel.exceptions.ReserveNotFoundException;
import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import ar.com.barnies.barnieshostel.models.User.User;
import ar.com.barnies.barnieshostel.models.room.Room;
import ar.com.barnies.barnieshostel.services.User.UserService;
import ar.com.barnies.barnieshostel.services.room.RoomService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        if (reserve.getPrice() != roomExist.getPrice()){
            throw new Exception("amount entered is different from room price");
        }

        if (reserve.getCheckInDate().isBefore(LocalDate.now())){
            throw new Exception("check in date cant be older than today.");
        }

        if (reserve.getCheckOutDate().isBefore(reserve.getCheckInDate())){
            throw new Exception("ckeck out date cant be older than check in date.");
        }

        if (!reservesOccupated.isEmpty()){
            throw new Exception("room not disponible in that dates.");
        }
        reserveRepository.create(reserve);
    }

    @Override
    public List<Reserve> getAllReserves() {
        try {
            return reserveRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la lista de reservas: " + e.getMessage());
            }
    }


    @Override
public Reserve getReserveById(Integer id) throws Exception {
    Reserve reserve = reserveRepository.getById(id);
    if (reserve == null) {
        throw new ReserveNotFoundException("Reserva con ID " + id + " no encontrada.");
    }
    return reserve;
}

    @Override
    public void deleteReserve(Integer id) throws Exception {
        Reserve existing = reserveRepository.getById(id);
        if (existing == null) {
            throw new ReserveNotFoundException("Reserva con ID " + id + " no encontrada.");
        }
        reserveRepository.delete(id);
}

    @Override
    public void updateReserve(Reserve reserve) throws Exception {
        Reserve existing = reserveRepository.getById(reserve.getId());
        if (existing == null) {
            throw new RuntimeException("Reserve does not exist");
        }

        if (reserve.getRoomId() == null){
            reserve.setRoomId(existing.getRoomId());
        } else {
            roomService.getRoomById(reserve.getRoomId());
        }

        if (reserve.getUserId() == null){
            reserve.setUserId(existing.getUserId());
        } else {
            userService.getUserById(reserve.getUserId());
        }

        if (reserve.getCheckInDate() == null){
            reserve.setCheckInDate(existing.getCheckInDate());
        } else if (reserve.getCheckInDate().isBefore(LocalDate.now())){
            throw new Exception("check in date update cant be older than today.");
        }

        if (reserve.getCheckOutDate() == null){
            reserve.setCheckOutDate(existing.getCheckOutDate());
        } else if (reserve.getCheckOutDate().isBefore(reserve.getCheckInDate())){
            throw new Exception("ckeck out date update cant be older than check in date.");
        }

        reserveRepository.update(reserve);
    }
}
