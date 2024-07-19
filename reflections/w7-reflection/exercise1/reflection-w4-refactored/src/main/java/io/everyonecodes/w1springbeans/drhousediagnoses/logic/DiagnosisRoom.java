package io.everyonecodes.w1springbeans.drhousediagnoses.logic;

import io.everyonecodes.w1springbeans.drhousediagnoses.communication.clients.TreatmentsClient;
import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private final DrHouse drHouse;
    private final TreatmentsClient treatmentsClient;

    public DiagnosisRoom(DrHouse drHouse, TreatmentsClient treatmentsClient) {
        this.drHouse = drHouse;
        this.treatmentsClient = treatmentsClient;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient); // setting the diagnose
        System.out.println("Patient with symptoms: " + patient.getSymptoms() +  "; diagnosed with " + patient.getDiagnosis());
        return treatmentsClient.addTreatment(patient);

    }
}
