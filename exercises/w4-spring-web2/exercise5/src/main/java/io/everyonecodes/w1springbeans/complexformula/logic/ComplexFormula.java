package io.everyonecodes.w1springbeans.complexformula.logic;

import io.everyonecodes.w1springbeans.complexformula.clients.FormulaClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ComplexFormula {

    private final FormulaClient formulaClient;

    public ComplexFormula(FormulaClient formulaClient) {
        this.formulaClient = formulaClient;
    }

    public String getCalculatedNumbers(String numberToCalculate) {
        String[] numbers = numberToCalculate.split("");

        return Arrays.stream(numbers)
                .map(formulaClient::sendAndCalculateNumber)
                .map(String::valueOf)
                .collect(Collectors.joining());

    }
}
