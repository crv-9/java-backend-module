package io.everyonecodes.w1springbeans.drivers;

import io.everyonecodes.w1springbeans.drivers.logic.DriverService;
import io.everyonecodes.w1springbeans.drivers.model.Driver;
import io.everyonecodes.w1springbeans.drivers.repositories.DriverRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

import static org.mockito.Mockito.*;

// Testing a service which connects to a mongoDB

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DriverServiceTest {

    // autowire the service you are directly testing
    @Autowired
    DriverService driverService;

    // Mock all the other Beans/classes which the service above has injected as dependencies
    @MockBean
    DriverRepository driverRepository;
    @MockBean
    PasswordEncoder passwordEncoder;
    // since we are doing security checks, you also need to mock the security beanm
    @MockBean
    SecurityFilterChain securityFilterChain;


    // Test find a user with an ID and doesn't create a new one
    @Test
    void findExistingDriver(){
        String username = "username";
        Driver driver = new Driver(username, "password", "test car");

        // here we check if the one method we want to test is being used and what it returns
        when(driverRepository.findOneByUsername(username))
                .thenReturn(Optional.of(driver));

        // here we make sure we call the method we want to test
        driverService.createDriver(driver);

        // here we make sure this specific method was called
        verify(driverRepository).findOneByUsername(username);
        verifyNoMoreInteractions(driverRepository);
    }

    // Test to create a new user

    @Test
    void createNewDriver(){
        String username = "username";
        when(driverRepository.findOneByUsername(username))
                .thenReturn(Optional.empty());

        Driver driver = new Driver(username, "password", "test car");

        driverService.createDriver(driver);

        verify(driverRepository).findOneByUsername(username);
        verify(driverRepository).save(driver);
    }




}
