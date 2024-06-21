package io.everyonecodes.w1springbeans.drhousediagnoses.logic;

import io.everyonecodes.w1springbeans.drhousediagnoses.config.DiagnosisConfiguration;
import io.everyonecodes.w1springbeans.drhousediagnoses.model.Diagnosis;
import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DrHouse {
    private final List<Diagnosis> diagnoses;

    public DrHouse(DiagnosisConfiguration diagnosisConfiguration) {
        this.diagnoses = diagnosisConfiguration.getDiagnoses();
    }

    public void diagnose(Patient patient) {
        Optional<Diagnosis> oDiagnosis = diagnoses.stream()
                .filter(diagnosis -> diagnosis.getSymptoms().equals(patient.getSymptoms()))
                .findFirst();
        if (oDiagnosis.isPresent()){
            patient.setDiagnosis(oDiagnosis.get().getName());
        } else patient.setDiagnosis("Lupus");
    }
}
