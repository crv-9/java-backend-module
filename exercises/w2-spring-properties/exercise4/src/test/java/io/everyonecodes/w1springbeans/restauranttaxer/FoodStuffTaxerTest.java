package io.everyonecodes.w1springbeans.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FoodStuffTaxerTest {

    @Autowired
    FoodStuffTaxer taxer;

    @ParameterizedTest
    @CsvSource({
            "false, ''",
            "false, wrong-dish",
            "true, tiramisu",
    })
    void matches(boolean expected, String name) {
        RestaurantDish dish = new RestaurantDish(name, 1.0);

        boolean result = taxer.matches(dish);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 0.0",
            "1.10, 1.0",
            "2.20, 2.0",
    })
    void tax(double expected, double price) {
        RestaurantDish dish = new RestaurantDish("name", price);

        double result = taxer.tax(dish);

        assertEquals(expected, result);
    }
}
