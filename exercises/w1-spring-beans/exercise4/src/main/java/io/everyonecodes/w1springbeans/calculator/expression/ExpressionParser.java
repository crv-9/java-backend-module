package io.everyonecodes.w1springbeans.calculator.expression;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressionParser {
    public Expression parse(String input) {
        List<String> inputElements = List.of(input.split(" "));
        return new Expression(inputElements.get(1),
                Double.parseDouble(inputElements.get(0)),
                Double.parseDouble(inputElements.get(2)));
    }
}
