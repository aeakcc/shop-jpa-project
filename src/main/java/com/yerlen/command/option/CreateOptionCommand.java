package com.yerlen.command.option;

import com.yerlen.entity.Option;
import com.yerlen.factory.OptionFactory;
import com.yerlen.repository.EntityRepository;
import com.yerlen.util.Command;

public class CreateOptionCommand implements Command {
    private final String optionName;

    public CreateOptionCommand(String optionName){
        this.optionName = optionName;
    }

    @Override
    public void execute() {
        Option option = OptionFactory.createOption(optionName);
        new EntityRepository().saveEntity(option);
        System.out.println("Success, new option" + optionName + " was created");
    }
}
