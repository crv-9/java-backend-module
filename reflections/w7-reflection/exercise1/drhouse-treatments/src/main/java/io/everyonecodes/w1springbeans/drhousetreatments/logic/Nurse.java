package io.everyonecodes.w1springbeans.drhousetreatments.logic;

import io.everyonecodes.w1springbeans.drhousetreatments.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class Nurse {
    private final TreatmentService treatmentService;

    public Nurse(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    // provide patient with treatment
    public void handlePatient(Patient patient) {
        addTreatment(patient);
        treatmentService.saveTreatment(patient);
    }

    // Later on, the exercise could be extended so that depending on the specific diagnosis of the incoming patient, a predefined treatment is provided.
    private void addTreatment(Patient patient) {
        patient.setTreatment("spend one day in the hospital bed");
    }

}
