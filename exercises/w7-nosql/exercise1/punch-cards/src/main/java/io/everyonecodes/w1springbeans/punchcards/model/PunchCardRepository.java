package io.everyonecodes.w1springbeans.punchcards.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PunchCardRepository extends MongoRepository<PunchCard, String> {
}
