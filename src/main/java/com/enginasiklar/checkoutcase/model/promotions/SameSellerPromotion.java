package com.enginasiklar.checkoutcase.model.promotions;

import com.enginasiklar.checkoutcase.model.Cart;
import com.enginasiklar.checkoutcase.model.items.Item;

public class SameSellerPromotion extends Promotion {
    private static final double DISCOUNT_RATE = 0.10;

    public SameSellerPromotion(int promotionId) {
        super(promotionId);
    }

    @Override
    public double applyPromotion(Cart cart) {
        boolean sameSeller = cart.getItems().stream()
                .map(Item::getSellerId)
                .distinct()
                .count() == 1;
        if (sameSeller) {
            double totalCartPrice = cart.calculateTotalPrice();
            return totalCartPrice * 0.10;  // 10% discount
        }
        return 0;
    }


}

