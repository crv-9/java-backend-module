package io.everyonecodes.w1springbeans.restauranttaxer;

import java.util.Objects;

public class RestaurantDish {
    private String name;
    private double price;

    public RestaurantDish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestaurantDish that)) return false;
        return Double.compare(price, that.price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
