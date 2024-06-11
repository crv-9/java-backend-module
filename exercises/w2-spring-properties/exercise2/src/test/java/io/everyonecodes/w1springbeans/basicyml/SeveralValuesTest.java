package io.everyonecodes.w1springbeans.basicyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeveralValuesTest {
    @Autowired
    SeveralValues severalValues;

    @Test
    void testSeveralValues() {
        // partially testing to check if the output is desired -no assertions
        System.out.println(severalValues.getNumbers());
        System.out.println(severalValues.getDecimalNumbers());
        System.out.println(severalValues.getWords());
        System.out.println(severalValues.getChoices());
    }
}
