package io.everyonecodes.w1springbeans.basket.logic;

import io.everyonecodes.w1springbeans.basket.model.ItemSelection;
import io.everyonecodes.w1springbeans.basket.model.Summary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Basket {

    private final SummaryCalculator summaryCalculator;


    public Basket(SummaryCalculator summaryCalculator) {
        this.summaryCalculator = summaryCalculator;
    }


    private List<ItemSelection> itemSelections = new ArrayList<>();
    private final List<Summary> summaries = new ArrayList<>();

    // method to get all item selections - if needed
    public List<ItemSelection> getItemSelections() {
        return itemSelections;
    }

    // method to add an item selection into the basket
    // I will automatically turn it into a summary
    public void addItemSelection(ItemSelection itemSelection) {
        this.itemSelections.add(itemSelection);
        summaries.add(summaryCalculator.getSummary(itemSelection));
    }

    public List<Summary> getSummaries() {
        return summaries;
    }


    // EXTRA
    // get all item selections in the basket from a specific user - if needed
    public List<ItemSelection> getItemSelectionsByUserEmail(String userEmail) {
        return itemSelections.stream()
                .filter(itemSelection -> itemSelection.getUserEmail().equals(userEmail))
                .toList();
    }


    public void setItemSelections(List<ItemSelection> itemSelections) {
        this.itemSelections = itemSelections;
    }




}
