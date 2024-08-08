package io.everyonecodes.w1springbeans.rides.repos;

import io.everyonecodes.w1springbeans.rides.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
