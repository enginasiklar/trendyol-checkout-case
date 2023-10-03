package com.enginasiklar.checkoutcase.model.promotions;

import com.enginasiklar.checkoutcase.model.Cart;
import com.enginasiklar.checkoutcase.model.items.Item;

public class CategoryPromotion extends Promotion {
    private static final double DISCOUNT_RATE = 0.05;

    public CategoryPromotion(int promotionId) {
        super(promotionId);
    }

    @Override
    public double applyPromotion(Cart cart) {
        double discount = 0;
        for (Item item : cart.getItems()) {
            if (item.getCategoryId() == 3003) {
                discount += item.getPrice() * item.getQuantity() * 0.05;  // 5% discount per eligible item
            }
        }
        return discount;
    }

}
