package io.everyonecodes.w1springbeans.calculator.calculation;


import io.everyonecodes.w1springbeans.calculator.expression.Expression;

public abstract class Calculation {
    String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression){
        return symbol.equals(expression.getSymbol());
    }

    public abstract double calculate(Expression expression);
}
