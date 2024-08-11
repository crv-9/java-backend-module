package io.everyonecodes.w1springbeans.drivers.logic;

import io.everyonecodes.w1springbeans.drivers.model.Driver;
import io.everyonecodes.w1springbeans.drivers.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;
    private final String driverRole;

    public DriverService(DriverRepository driverRepository, PasswordEncoder passwordEncoder,
                         @Value("${driver.role}") String driverRole) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
        this.driverRole = driverRole;
    }

    public Driver createDriver(Driver driver) {
        // TODO I need to check if Driver already exists
        Optional<Driver> oDriver = findDriverByUsername(driver.getUsername());
        if(oDriver.isPresent()) {
            return oDriver.get();
        } else {
        driver.setAuthorities(Set.of(driverRole));
        // saving the password as encrypted
        driver.setPassword(passwordEncoder.encode(driver.getPassword()));
        driverRepository.save(driver);
        return driver;}
    }

    public Optional<Driver> getDriverByID(String id){
        Optional<Driver> oDriver = driverRepository.findById(id);
        // [Extra] - here I am checking if the current user has authorization
        if (oDriver.isPresent()){
            Driver currentDriver = oDriver.get();
            String currentUsername = currentDriver.getUsername();
            if (currentUsername.equals(currentDriver.getUsername()) && hasRole(driverRole)){
                return oDriver;
            }
        }
        throw new AccessDeniedException("Access is denied");
    }

    public Driver updateDriverToAvailable(String id) {
        Optional<Driver> oCurrentDriver = driverRepository.findById(id);
        if (oCurrentDriver.isPresent()) {
            Driver driver = oCurrentDriver.get();
            // [Extra] - here I am checking if the current user has authorization
            if (isUserAuthorized(driver)){
                driver.setAvailable(true);
                return driverRepository.save(driver);
            }
        }
        throw new AccessDeniedException("Access is denied");
    }

    public Driver updateDriverToUnavailable(String id) {
        Optional<Driver> oCurrentDriver = driverRepository.findById(id);
        if (oCurrentDriver.isPresent()) {
            Driver driver = oCurrentDriver.get();
            // [Extra] - here I am checking if the current user has authorization
            if(isUserAuthorized(driver)){
                driver.setAvailable(false);
                return driverRepository.save(driver);
            }
        }
        throw new AccessDeniedException("Access is denied");
    }

    public Optional<Driver> findDriverByUsername(String username) {
        return driverRepository.findOneByUsername(username);
    }

    // [EXTRA]
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    // [EXTRA]
    public List<Driver> getAllAvailableDrivers(){
        return driverRepository.findAllByIsAvailable(true);
    }

    // [EXTRA]
    public List<Driver> getAllUnavailableDrivers(){
        return driverRepository.findAllByIsAvailable(false);
    }

    // [EXTRA] check if the current user is the owner of the entry
    // in previous set up any user could view and/or change the status of someone else

    private boolean isUserAuthorized(Driver driver) {
        String currentUsername = getCurrentUsername();
        return currentUsername.equals(driver.getUsername()) && hasRole(driverRole);
    }

    // Gets the currently authenticated user's username from the Principal object.
    private String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    // check whether the current driver has the proper role to view
    private boolean hasRole(String role) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }



}
