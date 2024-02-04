package com.yerlen.command.category;

import com.yerlen.entity.Category;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Command;

import java.util.List;

import static com.yerlen.repository.CategoryRepository.findAll;

public class ShowAllCategoriesCommand implements Command {
    private final SortStrategy<Category> sortStrategy;

    public ShowAllCategoriesCommand(SortStrategy<Category> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void execute() {
        List<Category> categories = findAll();
        categories = sortStrategy.sort(categories);
        categories.forEach(category -> System.out.printf("- %s [%d]\n", category.getName(), category.getId()));
    }
}
