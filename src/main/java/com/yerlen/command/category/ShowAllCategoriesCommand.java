package com.yerlen.command.category;

import com.yerlen.entity.Category;
import com.yerlen.repository.EntityRepository;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Command;

import java.util.List;

public class ShowAllCategoriesCommand implements Command {
    private final SortStrategy<Category> sortStrategy;

    public ShowAllCategoriesCommand(SortStrategy<Category> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void execute() {
        List<Category> categories = new EntityRepository().findAll(Category.class);
        categories = sortStrategy.sort(categories);
        categories.forEach(category -> System.out.printf("- %s [%d]\n", category.getName(), category.getId()));
    }
}
