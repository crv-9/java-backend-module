package io.everyonecodes.w1springbeans.rides.logic;

import io.everyonecodes.w1springbeans.rides.model.Driver;

import io.everyonecodes.w1springbeans.rides.model.DriverDTOComplete;
import io.everyonecodes.w1springbeans.rides.model.DriverDTOReduced;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverDTOTranslator {

    private final DriverService driverService;

    public DriverDTOTranslator(DriverService driverService) {
        this.driverService = driverService;
    }

    // translate from R-Driver [internal] to D-Driver [external]
    public DriverDTOReduced toDTOReduced(Driver driver) {
        return new DriverDTOReduced(driver.getUsername(), driver.getUsername()+"pass", driver.getCarType());
    }

    // translate from DTOComplete to Driver
    public Driver fromDTOComplete (DriverDTOComplete driverDTOComplete){
        Optional<Driver> oDriver = driverService.findDriverByUsername(driverDTOComplete.getUsername());
        if (oDriver.isPresent()){
            return driverService.addMongoDBIDToDriver(driverDTOComplete.getId(), oDriver.get());
        } else {
            return new Driver(driverDTOComplete.getUsername(), driverDTOComplete.getCarType(), driverDTOComplete.getId());
        }
    }

}
