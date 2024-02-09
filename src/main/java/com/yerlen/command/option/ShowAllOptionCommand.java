package com.yerlen.command.option;

import com.yerlen.entity.Option;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Command;

import java.util.List;

import static com.yerlen.repository.OptionRepository.findAll;

public class ShowAllOptionCommand implements Command {
    private final SortStrategy<Option> sortStrategy;

    public ShowAllOptionCommand(SortStrategy<Option> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void execute() {
        List<Option> options = findAll();
        options = sortStrategy.sort(options);
        options.forEach(option -> System.out.printf("- %s [%d]\n", option.getName(), option.getId()));
    }
}
