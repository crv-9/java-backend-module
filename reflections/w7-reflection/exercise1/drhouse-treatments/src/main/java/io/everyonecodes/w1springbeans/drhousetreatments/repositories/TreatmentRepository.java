package io.everyonecodes.w1springbeans.drhousetreatments.repositories;

import io.everyonecodes.w1springbeans.drhousetreatments.model.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TreatmentRepository extends MongoRepository<Treatment, String> {

    // return list of all saved treatments by patient uuid
    List<Treatment> findByUuid(String uuid);

}
