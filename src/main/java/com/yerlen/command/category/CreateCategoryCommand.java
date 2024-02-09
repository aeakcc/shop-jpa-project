package com.yerlen.command.category;

import com.yerlen.entity.Category;
import com.yerlen.factory.CategoryFactory;
import com.yerlen.repository.CategoryRepository;
import com.yerlen.util.Command;
import com.yerlen.view.View;

public class CreateCategoryCommand implements Command {
    private final String categoryName;

    public CreateCategoryCommand(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public void execute() {
        Category category = CategoryFactory.createCategory(categoryName);

        CategoryRepository.saveEntity(category);
        View.showCreateCategory(categoryName);
    }
}
