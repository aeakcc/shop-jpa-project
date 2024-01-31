package com.yerlen.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category extends ParentEntity implements Comparable<Category> {

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @OneToMany(mappedBy = "category")
    private List<Option> options;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Category(Long id, String name, List<Product> products, List<Option> options) {
        super(id, name);
        this.products = products;
        this.options = options;
    }

    public Category() {
    }

    @Override
    public int compareTo(Category o) {
        return Long.compare(super.getId(), o.getId());
    }
}
