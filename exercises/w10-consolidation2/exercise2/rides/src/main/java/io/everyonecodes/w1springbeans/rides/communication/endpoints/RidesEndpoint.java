package io.everyonecodes.w1springbeans.rides.communication.endpoints;

import io.everyonecodes.w1springbeans.rides.communication.clients.DriversClient;
import io.everyonecodes.w1springbeans.rides.logic.DriverService;
import io.everyonecodes.w1springbeans.rides.logic.RideService;
import io.everyonecodes.w1springbeans.rides.model.Driver;
import io.everyonecodes.w1springbeans.rides.model.Ride;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class RidesEndpoint {

    private final DriverService driverService;
    private final RideService rideService;
    // [EXTRA]
    private final DriversClient driversClient;

    public RidesEndpoint(DriverService driverService, RideService rideService, DriversClient driversClient) {
        this.driverService = driverService;
        this.rideService = rideService;
        this.driversClient = driversClient;
    }

    // POST a Driver to “/drivers” -> saves the Driver and returns it [for admins only]
    // [EXTRA] create a Driver in the D-app
    @PostMapping
    @Secured("ROLE_ADMIN")
    public Driver createDriver(@RequestBody Driver driver) {
        // here I am creating a Driver in D-app before saving it in R-app database
        Driver returnedDriver = driversClient.postDriver(driver);
        return driverService.createDriver(returnedDriver);
    }

    // GET to “/drivers” -> returns all Driver entries [for admins only]
    @GetMapping
    @Secured("ROLE_ADMIN")
    public List<Driver> getAllDrivers() {
        return driverService.findAllDrivers();
    }

    // POST a Ride to “/drivers/{id}/rides” -> saves the Ride, links it to the Driver that matches the id, and returns the Ride [for apps only]
    @PostMapping("/{id}/rides")
    @Secured("ROLE_APP")
    public Ride createRide(@PathVariable String id, @RequestBody Ride ride) {
        return rideService.createRide(id, ride);
    }

}
