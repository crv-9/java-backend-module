package io.everyonecodes.w1springbeans.drhousediagnoses;

import io.everyonecodes.w1springbeans.drhousediagnoses.logic.DiagnosisRoom;
import io.everyonecodes.w1springbeans.drhousediagnoses.logic.DrHouse;
import io.everyonecodes.w1springbeans.drhousediagnoses.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DiagnosisRoomTest {

    @Autowired
    private DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;
    Patient patient = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69","Lisa", "fatigue, appear pale");
    Patient expectedPatient = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69","Lisa", "fatigue, appear pale","anemia");
    @Test
    public void testDiagnosisRoom() {

        when(diagnosisRoom.diagnose(patient)).thenReturn(expectedPatient);

        Patient result = diagnosisRoom.diagnose(patient);

        assertEquals(expectedPatient, result);
        verify(drHouse).diagnose(patient);
    }
}
