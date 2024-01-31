package com.yerlen.command.option;

import com.yerlen.entity.Option;
import com.yerlen.repository.EntityRepository;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Command;

import java.util.List;

public class ShowAllOptionCommand implements Command {
    private final SortStrategy<Option> sortStrategy;

    public ShowAllOptionCommand(SortStrategy<Option> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void execute() {
        List<Option> options = new EntityRepository().findAll(Option.class);
        options = sortStrategy.sort(options);
        options.forEach(option -> System.out.printf("- %s [%d]\n", option.getName(), option.getId()));
    }
}
