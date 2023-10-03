package com.enginasiklar.checkoutcase.model.promotions;

import com.enginasiklar.checkoutcase.model.Cart;
import lombok.Getter;

@Getter
public abstract class Promotion {
    private final int promotionId;

    protected Promotion(int promotionId) {
        this.promotionId = promotionId;
    }

    public abstract double applyPromotion(Cart cart);
}

