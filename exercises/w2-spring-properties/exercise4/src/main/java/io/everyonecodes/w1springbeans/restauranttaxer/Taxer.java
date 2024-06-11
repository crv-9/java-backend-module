package io.everyonecodes.w1springbeans.restauranttaxer;

import java.util.List;

public abstract class Taxer {
    List<String> names;
    double tax;

    public Taxer(List<String> names, double tax) {
        this.names = names;
        this.tax = tax;
    }

    public boolean matches(RestaurantDish dish){
        return names.contains(dish.getName().toLowerCase());
    }

    public double tax(RestaurantDish dish){
        return dish.getPrice() * tax;
    }
}
