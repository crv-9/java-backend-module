package io.everyonecodes.w1springbeans.interactions.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {
    Set<String> colors = new HashSet<>();


    @GetMapping
    public Set<String> getColors() {
        return colors;
    }

    @GetMapping("/{name}")
    public String getColorByName(@PathVariable String name){
        if (colors.contains(name)){
            return name;
        } else return "The color is not available in the app";
    }

    @PostMapping
    public String addColor(@RequestBody String name){
        colors.add(name);
        return name;
    }

    @PutMapping("/{target}")
    public String updateColor(@PathVariable String target, @RequestBody String input){
        colors.remove(target);
        colors.add(input);
        return input;
    }

    @DeleteMapping
    public void deleteAllColors(){
        colors.clear();
    }

    @DeleteMapping("/{name}")
    public void deleteByColor(@PathVariable String name){
        colors.remove(name);
    }

}
