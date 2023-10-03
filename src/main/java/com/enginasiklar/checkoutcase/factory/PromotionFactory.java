package com.enginasiklar.checkoutcase.factory;

import com.enginasiklar.checkoutcase.model.promotions.CategoryPromotion;
import com.enginasiklar.checkoutcase.model.promotions.Promotion;
import com.enginasiklar.checkoutcase.model.promotions.SameSellerPromotion;
import com.enginasiklar.checkoutcase.model.promotions.TotalPricePromotion;

public class PromotionFactory {

    public enum PromotionType {
        SAME_SELLER,
        CATEGORY,
        TOTAL_PRICE
    }

    public static Promotion createPromotion(PromotionType promotionType, int promotionId) {
        return switch (promotionType) {
            case SAME_SELLER -> new SameSellerPromotion(promotionId);
            case CATEGORY -> new CategoryPromotion(promotionId);
            case TOTAL_PRICE -> new TotalPricePromotion(promotionId);
            default -> throw new IllegalArgumentException("Unknown promotion type: " + promotionType);
        };
    }
}
