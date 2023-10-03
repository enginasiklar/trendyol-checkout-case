package com.enginasiklar.checkoutcase.model;

import com.enginasiklar.checkoutcase.handler.PromotionHandler;
import com.enginasiklar.checkoutcase.model.items.DefaultItem;
import com.enginasiklar.checkoutcase.model.items.Item;
import com.enginasiklar.checkoutcase.model.items.VasItem;
import com.enginasiklar.checkoutcase.model.promotions.Promotion;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Cart {

    private final List<Item> items = new ArrayList<>();
    private Promotion appliedPromotion;
    private double totalDiscount;
    private final PromotionHandler promotionHandler;

    public Cart(PromotionHandler promotionHandler) {
        this.promotionHandler = promotionHandler;
    }

    public void addItem(Item item, int quantity) {
        item.setQuantity(quantity);
        items.add(item);
        validateCart();
    }

    public void addVasItemToItem(int itemId, VasItem vasItem) {
        Item item = findItemById(itemId);
        if (item instanceof DefaultItem) {
            ((DefaultItem) item).addVasItem(vasItem);
        }
        validateCart();
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
        validateCart();
    }

    public void resetCart() {
        items.clear();
        appliedPromotion = null;
        totalDiscount = 0;
    }

    public Map<String, Object> displayCart() {
        Map<String, Object> displayInfo = new HashMap<>();
        double totalPrice = calculateTotalPrice();
        displayInfo.put("items", items);
        displayInfo.put("totalPrice", totalPrice);
        displayInfo.put("appliedPromotionId", appliedPromotion != null ? appliedPromotion.getPromotionId() : null);
        displayInfo.put("totalDiscount", totalDiscount);
        return displayInfo;
    }

    double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public void applyBestPromotion() {
        promotionHandler.applyBestPromotion(this);
    }

    private void validateCart() {
        long uniqueItemsCount = items.stream().map(Item::getItemId).distinct().count();
        long totalItemsCount = items.stream().mapToLong(Item::getQuantity).sum();
        double totalPrice = calculateTotalPrice();

        if (uniqueItemsCount > 10 || totalItemsCount > 30 || totalPrice > 500000) {
            throw new IllegalArgumentException("Cart constraints violated");
        }
    }

    private Item findItemById(int itemId) {
        return items.stream().filter(item -> item.getItemId() == itemId).findFirst()
                .orElseThrow(() -> new NoSuchElementException("No item found with id " + itemId));
    }
}
