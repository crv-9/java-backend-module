package io.everyonecodes.w1springbeans.fizzbuzz.configuration;

import io.everyonecodes.w1springbeans.fizzbuzz.MultipleFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFinderConfiguration {

    @Bean
    public MultipleFinder multipleOfThree() {
        return new MultipleFinder(3);
    }

    @Bean
    public MultipleFinder multipleOfFive() {
        return new MultipleFinder(5);
    }
}
