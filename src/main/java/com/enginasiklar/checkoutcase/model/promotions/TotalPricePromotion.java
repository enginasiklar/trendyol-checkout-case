package com.enginasiklar.checkoutcase.model.promotions;

import com.enginasiklar.checkoutcase.model.Cart;

public class TotalPricePromotion extends Promotion {

    public TotalPricePromotion(int promotionId) {
        super(promotionId);
    }

    @Override
    public double applyPromotion(Cart cart) {
        double totalCartPrice = cart.calculateTotalPrice();
        if (totalCartPrice < 5000) {
            return 250;
        } else if (totalCartPrice < 10000) {
            return 500;
        } else if (totalCartPrice < 50000) {
            return 1000;
        } else {
            return 2000;
        }
    }

}
