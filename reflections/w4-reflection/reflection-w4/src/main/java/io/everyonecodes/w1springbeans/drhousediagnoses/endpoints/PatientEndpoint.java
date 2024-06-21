package io.everyonecodes.w1springbeans.drhousediagnoses.endpoints;

import io.everyonecodes.w1springbeans.drhousediagnoses.logic.DiagnosisRoom;
import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final DiagnosisRoom diagnosisRoom;
    public PatientEndpoint(DiagnosisRoom diagnosisRoom) {
        this.diagnosisRoom = diagnosisRoom;
    }

    @PostMapping
    public Patient postPatient(@RequestBody Patient patient){
        return diagnosisRoom.diagnose(patient);
    }
}
