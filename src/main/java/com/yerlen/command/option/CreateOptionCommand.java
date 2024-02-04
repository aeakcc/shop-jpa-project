package com.yerlen.command.option;

import com.yerlen.entity.Category;
import com.yerlen.entity.Option;
import com.yerlen.factory.OptionFactory;
import com.yerlen.repository.OptionRepository;
import com.yerlen.util.Command;
import com.yerlen.view.View;

public class CreateOptionCommand implements Command {
    private final String optionName;
    private final Category category;

    public CreateOptionCommand(String optionName, Category category) {
        this.optionName = optionName;
        this.category = category;
    }

    @Override
    public void execute() {
        Option option = OptionFactory.createOption(optionName, category);
        OptionRepository.saveEntity(option);
        View.showCreateOption(optionName);
    }
}
