package com.enginasiklar.checkoutcase.model.items;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DigitalItem extends Item {

    public DigitalItem(int itemId, int categoryId, int sellerId, double price, int quantity) {
        super(itemId, categoryId, sellerId, price, quantity);
    }
}
