package io.everyonecodes.w1springbeans.drivers.repositories;

import io.everyonecodes.w1springbeans.drivers.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver, String> {
    Optional<Driver> findOneByUsername(String username);
    //[Extra]
    List<Driver> findAllByIsAvailable(boolean isAvailable);
}
