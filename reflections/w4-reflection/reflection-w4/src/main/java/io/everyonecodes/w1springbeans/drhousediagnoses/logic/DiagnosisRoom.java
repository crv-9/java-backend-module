package io.everyonecodes.w1springbeans.drhousediagnoses.logic;

import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private final DrHouse drHouse;
    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient); // setting the diagnose
        System.out.println("Patient with symptoms: " + patient.getSymptoms() +  "; diagnosed with " + patient.getDiagnosis());
        return patient;
    }
}
