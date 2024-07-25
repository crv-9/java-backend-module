package io.everyonecodes.w1springbeans.phonebook.communication;

import io.everyonecodes.w1springbeans.phonebook.config.AddressRepository;
import io.everyonecodes.w1springbeans.phonebook.config.ContactRepository;
import io.everyonecodes.w1springbeans.phonebook.model.Address;
import io.everyonecodes.w1springbeans.phonebook.model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactEndpoint {
    // can be improved by adding a service class between endpoint and repos


    AddressRepository addressRepository;
    ContactRepository contactRepository;


    public ContactEndpoint(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;

    }

    // saves a new Contact along with its Address and returns the saved Contact.
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        addressRepository.save(contact.getAddress());
        return contactRepository.save(contact);
    }


    //GET to “/contacts” -> returns a list of all the saved Contacts.
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    //GET to “/contacts/postalcodes/{postalCode}” -> returns a list of all the saved Contacts that match the given postalCode.
    @GetMapping("/postalcodes/{postalCode}")
    public List<Contact> getContactsByPostalCode(@PathVariable String postalCode) {
        return contactRepository.findByAddressPostalCodeContaining(postalCode);
    }



}
