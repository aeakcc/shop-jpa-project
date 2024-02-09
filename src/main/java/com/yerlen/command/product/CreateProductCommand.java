package com.yerlen.command.product;

import com.yerlen.entity.Category;
import com.yerlen.entity.Product;
import com.yerlen.factory.ProductFactory;
import com.yerlen.repository.ProductRepository;
import com.yerlen.util.Command;
import com.yerlen.view.View;

import java.math.BigDecimal;

public class CreateProductCommand implements Command {
    private final String productName;
    private final BigDecimal productPrice;
    private final Category category;

    public CreateProductCommand(String productName, BigDecimal productPrice, Category category) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
    }

    @Override
    public void execute() {
        Product product = ProductFactory.createProduct(productName, productPrice, category);
        ProductRepository.saveEntity(product);
        View.showCreateOption(productName);
    }
}
