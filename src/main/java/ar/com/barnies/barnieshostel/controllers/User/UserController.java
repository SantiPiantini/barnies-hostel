package ar.com.barnies.barnieshostel.controllers.User;

import ar.com.barnies.barnieshostel.models.Reserve.Reserve;
import ar.com.barnies.barnieshostel.models.User.User;
import ar.com.barnies.barnieshostel.services.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) throws Exception {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserve> update(@PathVariable Integer id, @RequestBody User user) throws Exception{
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }
}