package io.everyonecodes.w1springbeans.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FizzBuzzTest {

    @Autowired
    FizzBuzz fizzBuzz;

    @ParameterizedTest
    @CsvSource({
            "Fizz, 3",
            "Fizz, 6",
            "Buzz, 5",
            "Buzz, 10",
            "FizzBuzz, 15",
            "FizzBuzz, 30",
            "1, 1",
            "2, 2",
    })
    void apply(String expected, int number) {
        String result = fizzBuzz.apply(number);

        assertEquals(expected, result);
    }
}