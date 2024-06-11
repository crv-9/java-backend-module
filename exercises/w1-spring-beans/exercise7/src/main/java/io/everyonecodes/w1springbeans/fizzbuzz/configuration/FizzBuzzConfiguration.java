package io.everyonecodes.w1springbeans.fizzbuzz.configuration;

import io.everyonecodes.w1springbeans.fizzbuzz.FizzBuzz;
import io.everyonecodes.w1springbeans.fizzbuzz.MultipleFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzConfiguration {

    @Bean
    public FizzBuzz fizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive) {
        return new FizzBuzz(multipleOfThree, multipleOfFive);
    }
}
