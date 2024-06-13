package io.everyonecodes.w1springbeans.calculator;

import io.everyonecodes.w1springbeans.calculator.expression.Expression;
import io.everyonecodes.w1springbeans.calculator.expression.ExpressionParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExpressionParserTest {

    @Autowired
    ExpressionParser expressionParser;

    @Test
    void parseExpression() {
        Expression result = expressionParser.parse("1 * 1");
        assertEquals(new Expression("*", 1, 1), result);
    }

}
