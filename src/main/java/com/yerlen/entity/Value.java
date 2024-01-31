package com.yerlen.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "values")
public class Value extends ParentEntity{

    @ManyToOne
    @JoinColumn(name = "options_id")
    private Option options;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Value(Long id, String name, Option options, Product product) {
        super(id, name);
        this.options = options;
        this.product = product;
    }

    public Value() {}

    public Option getOptions() {
        return options;
    }

    public void setOptions(Option options) {
        this.options = options;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
