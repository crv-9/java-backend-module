package io.everyonecodes.w1springbeans.drhousetreatments.logic;

import io.everyonecodes.w1springbeans.drhousetreatments.model.Patient;
import io.everyonecodes.w1springbeans.drhousetreatments.model.Treatment;
import io.everyonecodes.w1springbeans.drhousetreatments.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    // save the treatment applied to patient
    public void saveTreatment(Patient patient) {
        Treatment treatment = new Treatment(
                patient.getUuid(),
                patient.getName(),
                patient.getSymptoms(),
                patient.getDiagnosis(),
                patient.getTreatment()
        );

        treatmentRepository.save(treatment);
    }

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public List<Treatment> getTreatmentsByPatientUuid(String patientUuid) {
        return treatmentRepository.findByUuid(patientUuid);
    }




}
