package com.yerlen.factory;

import com.yerlen.entity.Category;

public class CategoryFactory {
    private CategoryFactory() {
    }

    public static Category createCategory(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        return category;
    }
}
