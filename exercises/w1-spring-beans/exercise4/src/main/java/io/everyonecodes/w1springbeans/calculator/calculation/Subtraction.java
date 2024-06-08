package io.everyonecodes.w1springbeans.calculator.calculation;

import io.everyonecodes.w1springbeans.calculator.expression.Expression;
import org.springframework.stereotype.Service;

@Service
public class Subtraction extends Calculation{

    public Subtraction() {
        super("-");
    }

    @Override
    public double calculate(Expression expression) {
        return expression.getTerm1() - expression.getTerm2();
    }
}
