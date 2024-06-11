package io.everyonecodes.w1springbeans.restauranttaxer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.ToDoubleFunction;

@Service
public class BillCalculator {
    private Set<Taxer> taxers;

    public BillCalculator(Set<Taxer> taxers) {
        this.taxers = taxers;
    }

    public double calculate(List<RestaurantDish> dishes){
        double sum = 0;
        for (RestaurantDish dish : dishes) {
            for (Taxer taxer : taxers) {
                if (taxer.names.contains(dish.getName())) {
                    sum += taxer.tax(dish);
                }
            }
        }
        return sum;
    }

    public double calculate2(List<RestaurantDish> dishes){
        double sum = 0;
        for (Taxer taxer : taxers) {
            for (RestaurantDish dish : dishes) {
                if (taxer.names.contains(dish.getName())) {
                    sum += taxer.tax(dish);
                }
            }
        }
        return sum;

    }

    public double calculate3(List<RestaurantDish> dishes){
        return dishes.stream()
                .mapToDouble(applyMatchingTax())
                .sum();
    }

    private ToDoubleFunction<RestaurantDish> applyMatchingTax(){
        return dish -> taxers.stream()
                .filter(taxer -> taxer.matches(dish))
                .map(taxer -> taxer.tax(dish))
                .findFirst()
                .orElse(dish.getPrice());
    }

}
