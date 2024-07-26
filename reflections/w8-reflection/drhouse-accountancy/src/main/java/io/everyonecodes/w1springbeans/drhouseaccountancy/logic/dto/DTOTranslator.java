package io.everyonecodes.w1springbeans.drhouseaccountancy.logic.dto;

import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Patient;
import io.everyonecodes.w1springbeans.drhouseaccountancy.model.PatientDTO;
import org.springframework.stereotype.Service;

@Service
public class DTOTranslator {

    public Patient translateDTOToPatient(PatientDTO patientDTO){
    // TODO add translation logic
        return new Patient(
                patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment()
        );
    }

    public void translatePatientToDTO(){
        // TODO add translation logic
    }

}
