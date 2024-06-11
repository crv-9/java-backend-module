package io.everyonecodes.w1springbeans.basicproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeveralValues {
    List<Integer> numbers;
    List<Double> decimalNumbers;
    List<String> words;
    List<Boolean> choices;

    public SeveralValues(@Value("${basic.several.naturalNumbers}") List<Integer> numbers,
                         @Value("${basic.several.decimalNumbers}") List<Double> decimalNumbers,
                         @Value("${basic.several.words}") List<String> words,
                         @Value("${basic.several.choices}") List<Boolean> choices) {
        this.numbers = numbers;
        this.decimalNumbers = decimalNumbers;
        this.words = words;
        this.choices = choices;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public List<Double> getDecimalNumbers() {return decimalNumbers;}
    public List<String> getWords() {return words;}
    public List<Boolean> getChoices() {return choices;}


}
