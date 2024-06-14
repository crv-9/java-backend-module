package io.everyonecodes.w1springbeans.drhouseadmission.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Admission {

    private final UUIDProvider uuidProvider;

    public Admission(UUIDProvider uuidProvider, UUIDProvider uuidProvider1){
        this.uuidProvider = uuidProvider1;
    }


    // most likely I don't have to create a new patient?
    public Patient admit(Patient patient){
        return new Patient(uuidProvider.provideUUID(patient), patient.getName());
    }

}
