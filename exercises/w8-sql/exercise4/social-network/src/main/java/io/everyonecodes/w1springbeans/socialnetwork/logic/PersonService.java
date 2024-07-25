package io.everyonecodes.w1springbeans.socialnetwork.logic;

import io.everyonecodes.w1springbeans.socialnetwork.config.PersonRepository;
import io.everyonecodes.w1springbeans.socialnetwork.model.Person;
import io.everyonecodes.w1springbeans.socialnetwork.model.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> getAllSavedPersonsAsDTOs() {
        List<Person> personList = getAllSavedPersons();
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (Person person : personList) {
            personDTOList.add(convertPersonToDTO(person));
        }

        return personDTOList;
    }

    public List<Person> getAllSavedPersons(){
        return personRepository.findAll();
    }

    public PersonDTO handlePerson(PersonDTO personDTO){
        Person createdPerson = convertDTOtoPerson(personDTO);
        return convertPersonToDTO(personRepository.save(createdPerson));
    }

    public void addFriend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        if (person1.getFriends().contains(person2)) {
            return;
        }
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);

        personRepository.save(person1);
        personRepository.save(person2);
    }

    public void removeFriend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);

        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();

        person1.getFriends().remove(person2);
        person2.getFriends().remove(person1);

        personRepository.save(person1);
        personRepository.save(person2);

    }


    // save Person
    private Person savePerson(Person person){
        return personRepository.save(person);
    }


    // turn PersonDTO to Person
    private Person convertDTOtoPerson(PersonDTO personDTO) {
        return new Person(personDTO.getName());
    }

    // turn Person to PersonDTO
    public PersonDTO convertPersonToDTO(Person person){
        return new PersonDTO(person.getId(),
                person.getName(),
                person.getFriends().stream()
                        .map(Person::getName)
                        .toList());


    }


}
