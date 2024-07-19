package io.everyonecodes.w1springbeans.drhousediagnoses.communication.clients;

import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class TreatmentsClient {

    private  final RestTemplate restTemplate;

    public TreatmentsClient(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // here I am receiving the patient already with treatment
    public Patient addTreatment(Patient patient) {
        String url = "http://localhost:9003/patients";
        return restTemplate.postForObject(url, patient, Patient.class);
    }

}
