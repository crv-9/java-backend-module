package io.everyonecodes.w1springbeans.drhouseaccountancy.communication.endpoints;

import io.everyonecodes.w1springbeans.drhouseaccountancy.logic.PatientService;
import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Patient;
import io.everyonecodes.w1springbeans.drhouseaccountancy.model.PatientDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    final PatientService patientService;

    public PatientEndpoint(PatientService patientService) {
        this.patientService = patientService;
    }

    // POST a PatientDTO to “/patients” -> Finds the Patient by uuid or saves a new one if it didn’t exist;
    // then generates an Invoice for that Patient, saves the Invoice, and returns the PatientDTO.

    @PostMapping
    public PatientDTO postPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.invoicePatient(patientDTO);
    }
}
