package com.yerlen.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "options")
public class Option extends ParentEntity {
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "options")
    private List<Value> values;

    public Option(Long id, String name, Category category, List<Value> values) {
        super(id, name);
        this.category = category;
        this.values = values;
    }

    public Option(){}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}