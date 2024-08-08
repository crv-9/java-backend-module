package io.everyonecodes.w1springbeans.rides.repos;

import io.everyonecodes.w1springbeans.rides.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByUsername(String username);
}
