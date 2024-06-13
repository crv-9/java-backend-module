package io.everyonecodes.w1springbeans.emergencynumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PoliceEmergencyTest {

    @Autowired
    PoliceEmergency policeEmergency;

    @Test
    void policeTest(){
        String result = policeEmergency.getName();
        System.out.println(result);
    }

}
