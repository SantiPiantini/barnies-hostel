package controllers.User;

import models.User.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ResponseEntity;
import services.User.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public UserService getReserveService() {
    }

}