package com.enginasiklar.checkoutcase.model.validators;

import com.enginasiklar.checkoutcase.model.items.Item;

import javax.validation.ValidationException;

public class VasItemValidator implements ItemValidator {

    @Override
    public void validate(Item item) throws ValidationException {
        if (item.getPrice() < 0) {
            throw new ValidationException("Price cannot be negative");
        }
        if (item.getQuantity() < 0 || item.getQuantity() > 3) {
            throw new ValidationException("Quantity must be between 0 and 3 for Vas Items");
        }
        if (item.getCategoryId() != 3242) {
            throw new ValidationException("Invalid category for Vas Item");
        }
        if (item.getSellerId() != 5003) {
            throw new ValidationException("Invalid seller for Vas Item");
        }
    }
}

