package io.everyonecodes.w1springbeans.phonebook.config;

import io.everyonecodes.w1springbeans.phonebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByAddressPostalCodeContaining(String postalCode);
}
