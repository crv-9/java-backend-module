package io.everyonecodes.w1springbeans.socialnetwork.config;

import io.everyonecodes.w1springbeans.socialnetwork.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
