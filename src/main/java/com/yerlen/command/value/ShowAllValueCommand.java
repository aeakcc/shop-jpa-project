package com.yerlen.command.value;

import com.yerlen.entity.Value;
import com.yerlen.repository.EntityRepository;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Command;

import java.util.List;

public class ShowAllValueCommand implements Command {
    private final SortStrategy<Value> sortStrategy;

    public ShowAllValueCommand(SortStrategy<Value> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void execute() {
        List<Value> values = new EntityRepository().findAll(Value.class);
        values = sortStrategy.sort(values);
        values.forEach(value -> System.out.printf("- %s [%d]\n", value.getName(), value.getId()));
    }
}
