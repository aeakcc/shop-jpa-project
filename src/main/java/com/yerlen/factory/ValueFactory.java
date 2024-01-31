package com.yerlen.factory;

import com.yerlen.entity.Value;

public class ValueFactory {
    private ValueFactory(){}

    public static Value createValue(String valueName){
        Value value = new Value();
        value.setName(valueName);
        return value;
    }
}
