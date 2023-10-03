package com.enginasiklar.checkoutcase.model.validators;

import com.enginasiklar.checkoutcase.model.items.Item;

import javax.validation.ValidationException;

public interface ItemValidator {
    void validate(Item item) throws ValidationException;
}

