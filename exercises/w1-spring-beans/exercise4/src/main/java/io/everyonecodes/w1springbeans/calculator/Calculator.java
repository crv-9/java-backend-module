package io.everyonecodes.w1springbeans.calculator;

import io.everyonecodes.w1springbeans.calculator.calculation.*;
import io.everyonecodes.w1springbeans.calculator.expression.Expression;
import io.everyonecodes.w1springbeans.calculator.expression.ExpressionParser;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Calculator {
    ExpressionParser expressionParser;
    Set<Calculation> calculations;

    public Calculator(ExpressionParser expressionParser, Set<Calculation> calculations) {
        this.expressionParser = expressionParser;
        this.calculations = calculations;
    }

    public double calculate(String input) {
        Expression expression = expressionParser.parse(input);
        return calculations.stream()
                .filter(calculation -> calculation.matches(expression))
                .map(calculation -> calculation.calculate(expression))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
