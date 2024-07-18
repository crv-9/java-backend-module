package io.everyonecodes.w1springbeans.thefinalcountdown.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountdownRepository extends MongoRepository<Countdown, String> {
}
