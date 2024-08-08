package io.everyonecodes.w1springbeans.rides.logic;

import io.everyonecodes.w1springbeans.rides.model.Ride;
import io.everyonecodes.w1springbeans.rides.repos.RideRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RideService {

    private final DriverService driverService;
    private final RideRepository rideRepository;

    public RideService(DriverService driverService, RideRepository rideRepository) {
        this.driverService = driverService;
        this.rideRepository = rideRepository;
    }

    public Ride createRide(String id, Ride ride) {
        rideRepository.save(ride);
        driverService.addRideToDriver(id, ride);
        return ride;
    }

}
