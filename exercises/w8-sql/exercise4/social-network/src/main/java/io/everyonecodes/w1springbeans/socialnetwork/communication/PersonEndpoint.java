package io.everyonecodes.w1springbeans.socialnetwork.communication;

import io.everyonecodes.w1springbeans.socialnetwork.logic.PersonService;
import io.everyonecodes.w1springbeans.socialnetwork.model.PersonDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonEndpoint {

    private final PersonService personService;

    public PersonEndpoint(PersonService personService) {
        this.personService = personService;
    }

    //POST a PersonDTO with only its name to “/persons” -> transforms the PersonDTO into a Person, saves the Person,
    // transforms it back to a PersonDTO and returns the new PersonDTO.

    @PostMapping
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personService.handlePerson(personDTO);

    }

    //GET to “/persons” -> returns all saved Persons as a list of PersonDTO.
    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personService.getAllSavedPersonsAsDTOs();
    }

    //PUT to “/persons/{id1}/friend/{id2}” -> connects the two Persons with id1 and id2 as friends.
    @PutMapping("/{id1}/friend/{id2}")
    void addFriend(@PathVariable Long id1, @PathVariable Long id2) {
        personService.addFriend(id1, id2);
    }

    //PUT to “/persons/{id1}/unfriend/{id2}” -> disconnects the friendship between the two Persons with id1 and id2.
    @PutMapping("/{id1}/unfriend/{id2}")
    void removeFriend(@PathVariable Long id1, @PathVariable Long id2) {
        personService.removeFriend(id1, id2);
    }
}
