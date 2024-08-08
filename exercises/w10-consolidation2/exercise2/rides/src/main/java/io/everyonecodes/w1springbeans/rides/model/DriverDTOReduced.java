package io.everyonecodes.w1springbeans.rides.model;

import java.util.Objects;

public class DriverDTOReduced {
    private String username;
    private String password;
    private String carType;

    public DriverDTOReduced() {
    }


    public DriverDTOReduced(String username, String password, String carType) {
        this.username = username;
        this.password = password;
        this.carType = carType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverDTOReduced that)) return false;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(carType, that.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, carType);
    }

    @Override
    public String toString() {
        return "DriverDTOReduced{" +
                "username='" + username + '\'' +
                ", generatedPassword='" + password + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
