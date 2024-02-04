package com.yerlen.factory;

import com.yerlen.entity.Option;
import com.yerlen.entity.Product;
import com.yerlen.entity.Value;

public class ValueFactory {
    private ValueFactory() {
    }

    public static Value createValue(String valueName, Option option, Product product) {
        Value value = new Value();
        value.setName(valueName);
        value.setOptions(option);
        value.setProduct(product);
        return value;
    }
}
