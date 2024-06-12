package io.everyonecodes.w1springbeans.advancedtypes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AcademyConfigurationTest {
    @Autowired
    private AcademyConfiguration academyConfiguration;

    @Test
    void testAcademyConfiguration() {
        List<Academy> result = academyConfiguration.getAcademies();

        for (Academy academy : result) {
            System.out.println(academy.getLocation());
        }
    }
}
