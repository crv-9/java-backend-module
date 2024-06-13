package io.everyonecodes.w1springbeans.advancedyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NaturalNumberTest {

    @Autowired
    NaturalNumber naturalNumber;

    @Test
    void getNaturalNumber() {
        int result = naturalNumber.getNaturalNumber();

        int expected = 369;
        assertEquals(expected, result);
    }
}
