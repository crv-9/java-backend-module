package io.everyonecodes.w1springbeans.returncollections;

public class Decoration {
    String name;
    double price;

    public Decoration() {
    }

    public Decoration(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}