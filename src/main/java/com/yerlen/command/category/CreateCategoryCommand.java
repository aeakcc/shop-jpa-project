package com.yerlen.command.category;

import com.yerlen.entity.Category;
import com.yerlen.factory.CategoryFactory;
import com.yerlen.repository.EntityRepository;
import com.yerlen.util.Command;

public class CreateCategoryCommand implements Command {
    private final String categoryName;

    public CreateCategoryCommand(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public void execute() {
        Category category = CategoryFactory.createCategory(categoryName);
        EntityRepository.saveEntity(category);
        // TODO запихать во View
        System.out.println("Success, new category " + categoryName + " was created");
    }
}
