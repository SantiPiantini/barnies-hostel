package ar.com.barnies.barnieshostel.repository.User;

import ar.com.barnies.barnieshostel.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringUserRepository extends JpaRepository<User, Integer> {
    //boolean existsByDni(String dni);
}