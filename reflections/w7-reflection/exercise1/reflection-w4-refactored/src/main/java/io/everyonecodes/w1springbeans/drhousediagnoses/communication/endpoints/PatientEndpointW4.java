package io.everyonecodes.w1springbeans.drhousediagnoses.communication.endpoints;

import io.everyonecodes.w1springbeans.drhousediagnoses.logic.DiagnosisRoom;
import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpointW4 {
    private final DiagnosisRoom diagnosisRoom;
    public PatientEndpointW4(DiagnosisRoom diagnosisRoom) {
        this.diagnosisRoom = diagnosisRoom;
    }

    @PostMapping
    public Patient postPatient(@RequestBody Patient patient){
        return diagnosisRoom.diagnose(patient);
    }
}
