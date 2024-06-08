package io.everyonecodes.w1springbeans.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTest {
    @Autowired
    Calculator calculator;

    @Test
    void calculateSum(){
        double result = calculator.calculate("1 + 1");
        assertEquals(2, result);
    }
    @Test
    void calculateSubtraction(){
        double result = calculator.calculate("1 - 1");
        assertEquals(0, result);
    }
    @Test
    void calculateMultiplication(){
        double result = calculator.calculate("1 * 3");
        assertEquals(3, result);
    }
    @Test
    void calculateDivision(){
        double result = calculator.calculate("1 / 2");
        assertEquals(0.5, result);
    }
}
