package com.enginasiklar.checkoutcase.factory;

import com.enginasiklar.checkoutcase.model.items.DefaultItem;
import com.enginasiklar.checkoutcase.model.items.DigitalItem;
import com.enginasiklar.checkoutcase.model.items.Item;
import com.enginasiklar.checkoutcase.model.items.VasItem;
import com.enginasiklar.checkoutcase.model.validators.ItemValidator;

import javax.validation.ValidationException;

public class ItemFactory {

    public enum ItemType {
        DEFAULT,
        DIGITAL,
        VAS
    }

    private final ValidatorFactory validatorFactory;

    public ItemFactory(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    public Item createItem(ItemType itemType, int itemId, int categoryId, int sellerId, double price, int quantity) throws ValidationException {
        Item item = switch (itemType) {
            case DEFAULT -> new DefaultItem(itemId, categoryId, sellerId, price, quantity);
            case DIGITAL -> new DigitalItem(itemId, categoryId, sellerId, price, quantity);
            case VAS -> new VasItem(itemId, categoryId, sellerId, price, quantity);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemType);
        };

        ItemValidator validator = validatorFactory.getValidator(itemType);
        validator.validate(item);

        return item;
    }
}

