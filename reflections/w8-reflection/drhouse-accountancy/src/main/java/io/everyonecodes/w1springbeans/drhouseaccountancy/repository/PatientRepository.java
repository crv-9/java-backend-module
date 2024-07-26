package io.everyonecodes.w1springbeans.drhouseaccountancy.repository;

import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findOneByUuid (String uuid);
}
