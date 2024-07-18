package io.everyonecodes.w1springbeans.thefinalcountdown.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccumulationRepository extends MongoRepository<Accumulation, String> {
}
