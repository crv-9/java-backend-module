package io.everyonecodes.w1springbeans.restauranttaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodStuffTaxer extends Taxer {

    public FoodStuffTaxer(@Value("${restaurant.foodstuff.names}") List<String> names, @Value("${restaurant.foodstuff.tax}") double tax) {
        super(names, tax);
    }

}
