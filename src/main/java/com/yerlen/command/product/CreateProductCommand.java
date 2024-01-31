package com.yerlen.command.product;

import com.yerlen.entity.Product;
import com.yerlen.factory.ProductFactory;
import com.yerlen.repository.EntityRepository;
import com.yerlen.util.Command;

import java.math.BigDecimal;

public class CreateProductCommand implements Command {
    private final String productName;
    private final BigDecimal productPrice;

    public CreateProductCommand(String productName, BigDecimal productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public void execute() {
        Product product = ProductFactory.createProduct(productName, productPrice);
        new EntityRepository().saveEntity(product);
        System.out.println("Success, new product " + productName + " was created");
    }
}
