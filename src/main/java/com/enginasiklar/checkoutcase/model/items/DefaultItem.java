package com.enginasiklar.checkoutcase.model.items;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DefaultItem extends Item {

    private final List<VasItem> vasItems = new ArrayList<>();

    public DefaultItem(int itemId, int categoryId, int sellerId, double price, int quantity) {
        super(itemId, categoryId, sellerId, price, quantity);
    }

    public void addVasItem(VasItem vasItem) {
        if (vasItems.size() < 3 && vasItem.getPrice() <= this.getPrice()
                && (this.getCategoryId() == 1001 || this.getCategoryId() == 3004)) {
            vasItems.add(vasItem);
        }
    }

}
