package io.everyonecodes.w1springbeans.basket.model;

import java.util.Objects;

public class ItemSelection {
    String userEmail;
    String itemName;
    double itemPrice;

    public ItemSelection(String userEmail, String itemName, double itemPrice) {
        this.userEmail = userEmail;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemSelection that)) return false;
        return Double.compare(itemPrice, that.itemPrice) == 0 && Objects.equals(userEmail, that.userEmail) && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, itemName, itemPrice);
    }
}
