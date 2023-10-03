package com.enginasiklar.checkoutcase.handler;

import com.enginasiklar.checkoutcase.model.Cart;
import com.enginasiklar.checkoutcase.model.promotions.Promotion;
import com.enginasiklar.checkoutcase.factory.PromotionFactory;
import com.enginasiklar.checkoutcase.factory.PromotionFactory.PromotionType;

import java.util.EnumSet;
public class PromotionHandler {

    public PromotionHandler(PromotionFactory promotionFactory) {
    }

    public void applyBestPromotion(Cart cart) {
        Promotion bestPromotion = null;
        double maxDiscount = 0;

        for (PromotionType type : EnumSet.allOf(PromotionType.class)) {
            Promotion promotion = PromotionFactory.createPromotion(type, getPromotionId(type));
            double discount = promotion.applyPromotion(cart);
            if (discount > maxDiscount) {
                maxDiscount = discount;
                bestPromotion = promotion;
            }
        }

        cart.setAppliedPromotion(bestPromotion);
        cart.setTotalDiscount(maxDiscount);
    }


    private int getPromotionId(PromotionType type) {
        return switch (type) {
            case SAME_SELLER -> 9909;
            case CATEGORY -> 5676;
            case TOTAL_PRICE -> 1232;
            default -> throw new IllegalArgumentException("Unknown promotion type: " + type);
        };
    }
}
