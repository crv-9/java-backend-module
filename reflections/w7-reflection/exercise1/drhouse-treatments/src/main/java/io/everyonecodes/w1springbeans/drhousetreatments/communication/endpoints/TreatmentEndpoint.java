package io.everyonecodes.w1springbeans.drhousetreatments.communication.endpoints;

import io.everyonecodes.w1springbeans.drhousetreatments.logic.TreatmentService;
import io.everyonecodes.w1springbeans.drhousetreatments.model.Patient;
import io.everyonecodes.w1springbeans.drhousetreatments.model.Treatment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {

    private final TreatmentService treatmentService;

    public TreatmentEndpoint(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping()
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/{uuid}")
    public List<Treatment> getTreatmentByUuid(@PathVariable String uuid) {
        return treatmentService.getTreatmentsByPatientUuid(uuid);
    }



}
