package com.enginasiklar.checkoutcase.model.items;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {

    private final int itemId;
    private final int categoryId;
    private final int sellerId;
    private double price;
    private int quantity;

    public Item(int itemId, int categoryId, int sellerId, double price, int quantity) {
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}
