package com.yerlen.factory;

import com.yerlen.entity.Product;

import java.math.BigDecimal;

public class ProductFactory {
    private ProductFactory(){}

    public static Product createProduct(String productName, BigDecimal price){
        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);
        return product;
    }
}
