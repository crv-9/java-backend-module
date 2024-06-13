package io.everyonecodes.w1springbeans.calculator;

import io.everyonecodes.w1springbeans.calculator.calculation.Addition;
import io.everyonecodes.w1springbeans.calculator.expression.Expression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdditionTest {
    @Autowired
    Addition addition;

    @Test
    void testAddition() {
        double result = addition.calculate(new Expression("+", 1, 1));

        assertEquals(2, result);
    }
}
