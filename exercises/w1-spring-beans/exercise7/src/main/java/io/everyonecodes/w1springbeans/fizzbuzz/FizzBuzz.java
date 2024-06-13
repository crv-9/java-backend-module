package io.everyonecodes.w1springbeans.fizzbuzz;


/*
* FizzBuzz.Injects the multipleOfThree and multipleOfFive beans.
* Has the apply method that receives a natural number and returns the word Fizz if the number is multiple of three,
* Buzz if the number is multiple of five,
* FizzBuzz if the number is multiple of both three and five, and otherwise the number as text.
 * */

public class FizzBuzz {

    private final MultipleFinder multipleOfThree;
    private final MultipleFinder multipleOfFive;

    public FizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive) {
        this.multipleOfThree = multipleOfThree;
        this.multipleOfFive = multipleOfFive;
    }

    public String apply(int numberInput) {
        if (multipleOfFive.isMultiple(numberInput) && multipleOfThree.isMultiple(numberInput)) {
            return "FizzBuzz";
        }
        if (multipleOfFive.isMultiple(numberInput)) {
            return "Buzz";
        }
        if (multipleOfThree.isMultiple(numberInput)) {
            return "Fizz";
        }
        return String.valueOf(numberInput);
    }
}
