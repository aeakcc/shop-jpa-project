package com.yerlen.command.product;

import com.yerlen.entity.Product;
import com.yerlen.repository.EntityRepository;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Command;

import java.util.List;

public class ShowAllProductCommand implements Command {
    private final SortStrategy<Product> sortStrategy;

    public ShowAllProductCommand(SortStrategy<Product> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void execute() {
        List<Product> products = new EntityRepository().findAll(Product.class);
        products = sortStrategy.sort(products);
        products.forEach(product -> System.out.printf("- %s [%d]\n", product.getName(), product.getId()));
    }
}
