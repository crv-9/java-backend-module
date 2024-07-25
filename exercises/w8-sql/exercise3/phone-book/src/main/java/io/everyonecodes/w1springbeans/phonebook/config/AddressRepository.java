package io.everyonecodes.w1springbeans.phonebook.config;

import io.everyonecodes.w1springbeans.phonebook.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPostalCode(String postalCode);

}
