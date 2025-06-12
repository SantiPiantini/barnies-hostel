package models.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "Máximo 100 caracteres")
    private String username;

    @NotNull(message = "El DNI no puede ser nulo")
    @Min(value = 1000000, message = "El DNI debe tener al menos 7 dígitos")
    private Integer dni;

    public User() {}

    public User(Integer userID, String username, Integer dni) {
        this.userID = userID;
        this.username = username;
        this.dni = dni;
    }

    // Getters y setters
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
