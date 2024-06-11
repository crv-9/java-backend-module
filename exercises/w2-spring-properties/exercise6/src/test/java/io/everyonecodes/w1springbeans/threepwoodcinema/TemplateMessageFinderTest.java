package io.everyonecodes.w1springbeans.threepwoodcinema;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TemplateMessageFinderTest {
    @Autowired
    TemplateMessageFinder finder;

    @ParameterizedTest
    @CsvSource({
            "default --name--, Guybrush",
            "male --name--, Mr. Guybrush",
            "female --name--, Ms. Guybrush",
            "privileged --name--, Sir Guybrush Threepwood",
    })
    void find(String expected, String customerName) {
        String result = finder.find(customerName);

        assertEquals(expected, result);
    }

}
