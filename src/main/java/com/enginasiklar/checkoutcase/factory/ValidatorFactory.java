package com.enginasiklar.checkoutcase.factory;

import com.enginasiklar.checkoutcase.model.validators.DefaultItemValidator;
import com.enginasiklar.checkoutcase.model.validators.DigitalItemValidator;
import com.enginasiklar.checkoutcase.model.validators.ItemValidator;
import com.enginasiklar.checkoutcase.model.validators.VasItemValidator;

public class ValidatorFactory {

    public ItemValidator getValidator(ItemFactory.ItemType itemType) {
        return switch (itemType) {
            case DEFAULT -> new DefaultItemValidator();
            case DIGITAL -> new DigitalItemValidator();
            case VAS -> new VasItemValidator();
            default -> throw new IllegalArgumentException("Unknown item type: " + itemType);
        };
    }
}

