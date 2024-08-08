package io.everyonecodes.w1springbeans.rides.logic;

import io.everyonecodes.w1springbeans.rides.model.Driver;
import io.everyonecodes.w1springbeans.rides.model.Ride;
import io.everyonecodes.w1springbeans.rides.repos.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> findDriverById(String id) {
        return driverRepository.findById(Long.valueOf(id));
    }

    public void addRideToDriver(String id, Ride ride) {
        Driver driver = findDriverById(id).orElseThrow();
        driver.getRides().add(ride);
        driverRepository.save(driver);
    }

    // [EXTRA]
    public Optional<Driver> findDriverByUsername(String username) {
        return driverRepository.findByUsername(username);
    }

    // [EXTRA]
    public Driver addMongoDBIDToDriver(String mongoID, Driver driver) {
        driver.setMongoDBID(mongoID);
        return driverRepository.save(driver);
    }


}
