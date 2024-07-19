package io.everyonecodes.w1springbeans.basket.model;

import java.util.Objects;

public class Summary {
    String userEmail;
    String itemName;
    double itemPrice;
    double deliveryCost;
    double totalPrice;

    public Summary(String userEmail, String itemName, double itemPrice, double deliveryCost, double totalPrice) {
        this.userEmail = userEmail;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.deliveryCost = deliveryCost;
        this.totalPrice = totalPrice;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Summary summary)) return false;
        return Double.compare(itemPrice, summary.itemPrice) == 0 && Double.compare(deliveryCost, summary.deliveryCost) == 0 && Double.compare(totalPrice, summary.totalPrice) == 0 && Objects.equals(userEmail, summary.userEmail) && Objects.equals(itemName, summary.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, itemName, itemPrice, deliveryCost, totalPrice);
    }
}
