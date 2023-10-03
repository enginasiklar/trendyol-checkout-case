package com.enginasiklar.checkoutcase.model.validators;

import com.enginasiklar.checkoutcase.model.items.Item;

import javax.validation.ValidationException;

public class DefaultItemValidator implements ItemValidator {

    @Override
    public void validate(Item item) throws ValidationException {
        if (item.getPrice() < 0) {
            throw new ValidationException("Price cannot be negative");
        }
        if (item.getQuantity() < 0 || item.getQuantity() > 10) {
            throw new ValidationException("Quantity must be between 0 and 10");
        }
    }
}


