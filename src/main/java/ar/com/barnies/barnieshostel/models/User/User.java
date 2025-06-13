package ar.com.barnies.barnieshostel.models.User;

import jakarta.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userID;

    @Column(name = "username")
    private String username;

    @Column(name = "dni")
    private Integer dni;

    public User() {
    }

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
