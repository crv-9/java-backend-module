package io.everyonecodes.w1springbeans.fleamarket.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {
    List<Item> items = new ArrayList<>();

    public MarketService(List<Item> items) {
        this.items = items;
    }

    public List<Item> getAllItems() {
        return items;
    }

    public List<Item> getItemsByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .toList();
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
