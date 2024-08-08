package io.everyonecodes.w1springbeans.drivers.communication.endpoints;

import io.everyonecodes.w1springbeans.drivers.logic.DriverService;
import io.everyonecodes.w1springbeans.drivers.model.Driver;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriversEndpoint {

    private final DriverService driverService;

    public DriversEndpoint(DriverService driverService) {
        this.driverService = driverService;
    }

    //Post a Driver to “/drivers” -> processes the Driver, saves it in the database and returns it [available to everyone]
    @PostMapping
    public Driver createDriver(@RequestBody Driver driver){
        return driverService.createDriver(driver);
    }

    //GET to “/drivers/{id}” -> returns the Driver with the matching id [for drivers + admin]
    @GetMapping("/{id}")
    @Secured("ROLE_DRIVER")
    public Driver getDriver(@PathVariable String id) {
        Optional<Driver> returnedDriver = driverService.getDriverByID(id);
        return returnedDriver.orElse(null);

    }

    //PUT to “/drivers/{id}/available” -> tags the Driver with the matching id as available [for drivers only]
    @PutMapping("/{id}/available")
    @Secured("ROLE_DRIVER")
    public Driver updateDriverAvailable(@PathVariable String id){
        return driverService.updateDriverToAvailable(id);
    }

    //PUT to “/drivers/{id}/unavailable” -> tags the Driver with the matching id as not available [for drivers only]
    @PutMapping("/{id}/unavailable")
    @Secured("ROLE_DRIVER")
    public Driver updateDriverUnavailable(@PathVariable String id){
        return driverService.updateDriverToUnavailable(id);
    }

    // [EXTRA] GET to "/drivers/all" - returns all drivers in the system [for admin only]
    @GetMapping("/all")
    @Secured("ROLE_ADMIN")
    public List<Driver> getDriversForAdmin() {
        return driverService.getAllDrivers();
    }

    // [EXTRA] GET to "/drivers/all-available" - returns all current available drivers in the system [for admin only]
    @GetMapping("/all-available")
    @Secured("ROLE_ADMIN")
    public List<Driver> getAvailableDriversForAdmin() {
        return driverService.getAllAvailableDrivers();
    }

    // [EXTRA] GET to "/drivers/all-unavailable" - returns all current unavailable drivers in the system [for admin only]
    @GetMapping("/all-unavailable")
    @Secured("ROLE_ADMIN")
    public List<Driver> getUnavailableDriversForAdmin() {
        return driverService.getAllUnavailableDrivers();
    }
}
