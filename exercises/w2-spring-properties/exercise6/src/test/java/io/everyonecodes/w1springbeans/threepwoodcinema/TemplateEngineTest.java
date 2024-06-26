package io.everyonecodes.w1springbeans.threepwoodcinema;

import io.everyonecodes.w1springbeans.threepwoodcinema.logic.TemplateEngine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TemplateEngineTest {
    @Autowired
    TemplateEngine templateEngine;

    @ParameterizedTest
    @CsvSource({
            "default Guybrush, Guybrush",
            "male Mr. Guybrush, Mr. Guybrush",
            "female Ms. Guybrush, Ms. Guybrush",
            "privileged Sir Guybrush Threepwood, Sir Guybrush Threepwood",
    })
    void customiseMessage(String expected, String customerName) {
        String result = templateEngine.customiseMessage(customerName);

        assertEquals(expected, result);
    }
}
