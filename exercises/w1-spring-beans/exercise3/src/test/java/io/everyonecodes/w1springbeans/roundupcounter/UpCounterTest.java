package io.everyonecodes.w1springbeans.roundupcounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UpCounterTest {
    @Autowired
    UpCounter upCounter;

    @Test
    public void testUpCounter() {
        List<Double> numbers = List.of(1.0, 2.6, 3.7, 4.8);

        int result = upCounter.count(numbers);
        int expected = 3;

        assertEquals(expected, result);
    }
}
