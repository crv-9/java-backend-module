package io.everyonecodes.w1springbeans.rides.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String carType;
    private String mongoDBID;

    @OneToMany
    List<Ride> rides;

    public Driver() {
    }

    public Driver(String username, String carType) {
        this.username = username;
        this.carType = carType;
    }

    public Driver(String username, String carType, String mongoDBID) {
        this.username = username;
        this.carType = carType;
        this.mongoDBID = mongoDBID;
    }

    public Driver(Long id, String username, String carType, String mongoDBID, List<Ride> rides) {
        this.id = id;
        this.username = username;
        this.carType = carType;
        this.mongoDBID = mongoDBID;
        this.rides = rides;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public String getMongoDBID() {
        return mongoDBID;
    }

    public void setMongoDBID(String mongoDBID) {
        this.mongoDBID = mongoDBID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver driver)) return false;
        return Objects.equals(id, driver.id) && Objects.equals(username, driver.username) && Objects.equals(carType, driver.carType) && Objects.equals(mongoDBID, driver.mongoDBID) && Objects.equals(rides, driver.rides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, carType, mongoDBID, rides);
    }
}
