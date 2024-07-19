package io.everyonecodes.w1springbeans.drhousetreatments.communication.endpoints;

import io.everyonecodes.w1springbeans.drhousetreatments.logic.Nurse;
import io.everyonecodes.w1springbeans.drhousetreatments.logic.TreatmentService;
import io.everyonecodes.w1springbeans.drhousetreatments.model.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final Nurse nurse;


    public PatientEndpoint(Nurse nurse) {
        this.nurse = nurse;

    }

    // post a patient which will then be treated
    @PostMapping()
    public Patient addTreatmentToPatient(@RequestBody Patient patient) {
        nurse.handlePatient(patient);
        return patient;
    }
}
