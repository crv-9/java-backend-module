package io.everyonecodes.w1springbeans.fleamarket.controllers;

import io.everyonecodes.w1springbeans.fleamarket.model.Item;
import io.everyonecodes.w1springbeans.fleamarket.model.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class MarketEndpoint {

    MarketService marketService;
    public MarketEndpoint(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public List<Item> getAllItems(){
        return marketService.getAllItems();
    }

    @GetMapping("/{name}")
    public List<Item> getItemsByName(@PathVariable String name){
        return marketService.getItemsByName(name);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item){
        System.out.println("item added: " + item.getName());
        marketService.addItem(item);
        return item;
    }
}
