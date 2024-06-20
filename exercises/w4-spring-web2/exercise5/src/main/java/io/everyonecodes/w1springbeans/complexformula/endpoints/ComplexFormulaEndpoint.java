package io.everyonecodes.w1springbeans.complexformula.endpoints;

import io.everyonecodes.w1springbeans.complexformula.logic.ComplexFormula;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complexformula")
public class ComplexFormulaEndpoint {

    private final ComplexFormula complexFormula;
    public ComplexFormulaEndpoint(ComplexFormula complexFormula) {
        this.complexFormula = complexFormula;
    }

    @GetMapping("/{number}")
    public String getNumber(@PathVariable String number) {
        return complexFormula.getCalculatedNumbers(number);
    }

}
