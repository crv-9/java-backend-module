package io.everyonecodes.w1springbeans.drivers.model;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Driver {
    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;
    private String carType;
    private boolean isAvailable;

    // do I need to set this new HashSet<>() ?
    private Set<String> authorities = new HashSet<>();


    public Driver() {
    }

    public Driver(String username, String password, String carType, boolean isAvailable) {
        this.username = username;
        this.password = password;
        this.carType = carType;
        this.isAvailable = false;
    }

    public Driver(String id, String username, String password, String carType, boolean isAvailable, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.carType = carType;
        this.isAvailable = false;
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver driver)) return false;
        return Objects.equals(id, driver.id) && Objects.equals(username, driver.username) && Objects.equals(password, driver.password) && Objects.equals(carType, driver.carType) && Objects.equals(authorities, driver.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, carType, authorities);
    }
}
