package com.yerlen.factory;

import com.yerlen.entity.Category;
import com.yerlen.entity.Product;

import java.math.BigDecimal;

public class ProductFactory {
    private ProductFactory() {
    }

    public static Product createProduct(String productName, BigDecimal price, Category category) {
        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);
        product.setCategory(category);
        return product;
    }
}
