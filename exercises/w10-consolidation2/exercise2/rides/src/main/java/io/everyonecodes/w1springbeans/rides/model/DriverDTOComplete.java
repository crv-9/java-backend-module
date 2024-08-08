package io.everyonecodes.w1springbeans.rides.model;

import java.util.Objects;
import java.util.Set;

public class DriverDTOComplete {

    private String id;
    private String username;
    private String password;
    private String carType;
    private Set<String> authorities;
    private boolean available;

    public DriverDTOComplete() {
    }

    public DriverDTOComplete(String id, String username, String password, String carType, Set<String> authorities, boolean available) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.carType = carType;
        this.authorities = authorities;
        this.available = available;
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
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverDTOComplete that)) return false;
        return available == that.available && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(carType, that.carType) && Objects.equals(authorities, that.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, carType, authorities, available);
    }

    @Override
    public String toString() {
        return "DriverDTOComplete{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", carType='" + carType + '\'' +
                ", authorities=" + authorities +
                ", available=" + available +
                '}';
    }
}
