package io.everyonecodes.w1springbeans.drhousediagnoses;

import io.everyonecodes.w1springbeans.drhousediagnoses.endpoints.PatientEndpoint;
import io.everyonecodes.w1springbeans.drhousediagnoses.logic.DiagnosisRoom;
import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientEndpointTest {

    @Autowired
    PatientEndpoint patientEndpoint;

    @MockBean
    DiagnosisRoom diagnosisRoom;

    String url = "/patients";

    Patient patient = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69","Lisa", "fatigue, appear pale");
    Patient expectedPatient = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69","Lisa", "fatigue, appear pale","anemia");


    @Test
    void test(){
        when(patientEndpoint.postPatient(patient)).thenReturn(expectedPatient);

        Patient actual = patientEndpoint.postPatient(patient);

        assertEquals(expectedPatient, actual);
        verify(diagnosisRoom).diagnose(patient);
    }
}
