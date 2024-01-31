package com.yerlen.factory;

import com.yerlen.entity.Option;

public class OptionFactory {
    private OptionFactory(){}

    public static Option createOption(String optionName){
        Option option = new Option();
        option.setName(optionName);
        return option;
    }
}
