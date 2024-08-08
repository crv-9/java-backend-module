package io.everyonecodes.w1springbeans.rides.communication.clients;

import io.everyonecodes.w1springbeans.rides.logic.DriverDTOTranslator;
import io.everyonecodes.w1springbeans.rides.model.Driver;
import io.everyonecodes.w1springbeans.rides.model.DriverDTO;
import io.everyonecodes.w1springbeans.rides.model.DriverDTOComplete;
import io.everyonecodes.w1springbeans.rides.model.DriverDTOReduced;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DriversClient {
    private final RestTemplate restTemplate;
    private final DriverDTOTranslator driverDTOTranslator;
    private final String baseUrl = "http://localhost:9100/drivers";

    public DriversClient(RestTemplate restTemplate, DriverDTOTranslator driverDTOTranslator) {
        this.restTemplate = restTemplate;
        this.driverDTOTranslator = driverDTOTranslator;
    }

    // [EXTRA] Post a Driver to D-app
    public Driver postDriver(Driver driver) {
        DriverDTOReduced driverDTOReduced = driverDTOTranslator.toDTOReduced(driver);
        System.out.println("about to send DTO here is the DriverDTO class: " + driverDTOReduced.toString());
        // here I am sending the DTO and receiving a DTO

        DriverDTOComplete receivedDTO = restTemplate.postForObject(baseUrl,driverDTOReduced, DriverDTOComplete.class);

        System.out.println("this is what we received back: " + receivedDTO.toString());

        return driverDTOTranslator.fromDTOComplete(receivedDTO);
    }

    // Getting a list of Drivers from D-app
    public List<Driver> getDrivers() {
        DriverDTOComplete[] incomingDriverDTOCompletes = restTemplate.getForObject(baseUrl, DriverDTOComplete[].class);
        assert incomingDriverDTOCompletes != null;

        ArrayList<DriverDTOComplete> driverDTOCompletes = new ArrayList<>(Arrays.asList(incomingDriverDTOCompletes));

        return driverDTOCompletes.stream()
                .map(driverDTOTranslator::fromDTOComplete)
                .toList();
    }

}
