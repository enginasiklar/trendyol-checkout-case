package com.enginasiklar.checkoutcase.model.validators;

import com.enginasiklar.checkoutcase.model.items.Item;

import javax.validation.ValidationException;

public class DigitalItemValidator implements ItemValidator {

    @Override
    public void validate(Item item) throws ValidationException {
        if (item.getPrice() < 0) {
            throw new ValidationException("Price cannot be negative");
        }
        if (item.getQuantity() < 0 || item.getQuantity() > 5) {
            throw new ValidationException("Quantity must be between 0 and 5 for Digital Items");
        }
        if (item.getCategoryId() != 7889) {
            throw new ValidationException("Invalid category for Digital Item");
        }
    }
}
