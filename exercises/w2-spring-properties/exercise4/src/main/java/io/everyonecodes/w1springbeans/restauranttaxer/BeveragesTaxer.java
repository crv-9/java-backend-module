package io.everyonecodes.w1springbeans.restauranttaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeveragesTaxer extends Taxer{
    public BeveragesTaxer(@Value("${restaurant.beverages.names}")List<String> names, @Value("${restaurant.beverages.tax}") double tax) {
        super(names, tax);
    }
}
