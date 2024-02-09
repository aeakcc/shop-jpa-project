package com.yerlen.factory;

import com.yerlen.entity.Category;
import com.yerlen.entity.Option;

public class OptionFactory {
    private OptionFactory() {
    }

    public static Option createOption(String optionName, Category category) {
        Option option = new Option();
        option.setName(optionName);
        option.setCategory(category);
        return option;
    }
}
