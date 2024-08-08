package io.everyonecodes.w1springbeans.rides.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // should this have a @OneToMany relationship?
    String username;
    double distance;
    double price;

    public Ride() {
    }

    public Ride(String username, double distance, double price) {
        this.username = username;
        this.distance = distance;
        this.price = price;
    }

    public Ride(Long id, String username, double distance, double price) {
        this.id = id;
        this.username = username;
        this.distance = distance;
        this.price = price;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ride ride)) return false;
        return Double.compare(distance, ride.distance) == 0 && Double.compare(price, ride.price) == 0 && Objects.equals(id, ride.id) && Objects.equals(username, ride.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, distance, price);
    }
}
