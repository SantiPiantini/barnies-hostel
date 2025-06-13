package ar.com.barnies.barnieshostel.models.room;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer id;

    @Column(name = "room_number")
    private String name;

    @Column(name = "bed_count")
    private Integer capacity;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private double price;

    public Room(Integer id, String name, Integer capacity, String status, double price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
        this.price = price;
    }

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
