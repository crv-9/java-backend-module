package io.everyonecodes.w1springbeans.emergencynumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmergencyNumberProviderTest {

    @Autowired
    EmergencyNumberProvider emergencyNumberProvider;

    @ParameterizedTest
    @CsvSource({
            "112,''",
            "122,Fire brigade",
            "133,Police",
            "112,General emergency"
    })
    void provide(int expected, String input) {
        System.out.println(expected);
        int result = emergencyNumberProvider.provideEmergencyNumber(input);
        System.out.println(result);
        assertEquals(expected, result);
    }
}
