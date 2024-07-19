package io.everyonecodes.w1springbeans.basket.communication.endpoints;

import io.everyonecodes.w1springbeans.basket.logic.Basket;
import io.everyonecodes.w1springbeans.basket.model.ItemSelection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemselections")
public class ItemSelectionEndpoint {

    private final Basket basket;

    public ItemSelectionEndpoint(Basket basket) {
        this.basket = basket;
    }


    // working as expected
    @PostMapping
    public ItemSelection addItemSelection(@RequestBody ItemSelection itemSelection) {
        basket.addItemSelection(itemSelection);
        return itemSelection;
    }

    // returning all item selections - testing purposes
    @GetMapping
    public List<ItemSelection> getItemSelections() {
        return basket.getItemSelections();
    }



}
