package com.yerlen.entity;


import com.yerlen.command.category.CreateCategoryCommand;
import com.yerlen.command.category.ShowAllCategoriesCommand;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Process;
import com.yerlen.view.View;
import jakarta.persistence.*;

import java.util.List;

import static com.yerlen.processors.AllProcesses.SCANNER;
import static com.yerlen.processors.AllProcesses.sort;

@Entity
@Table(name = "category")
public class Category implements Comparable<Category>, Process {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @OneToMany(mappedBy = "category")
    private List<Option> options;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        this.id = id;
        this.name = name;
        this.products = products;
        this.options = options;
    }

    public Category() {
    }

    @Override
    public int compareTo(Category o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public void processEntity() {
        boolean stillInLoop = true;
        while (stillInLoop) {
            View.showCategoryMenu();
            String input = SCANNER.nextLine();
            switch (input) {
                case "1":
                    View.showCategoryName();
                    input = SCANNER.nextLine();
                    CreateCategoryCommand create = new CreateCategoryCommand(input);
                    create.execute();
                    break;
                case "2":
                    SortStrategy sortStrategy = sort();
                    ShowAllCategoriesCommand categoriesCommand = new ShowAllCategoriesCommand(sortStrategy);
                    categoriesCommand.execute();
                    break;
                case "3":
                    new Option().processEntity();
                    break;
                case "4":
                    new Product().processEntity();
                    break;
                case "5":
                    new Value().processEntity();
                    break;
                case "6":
                    stillInLoop = false;
                    break;
                default:
                    View.showWrongValue();
            }
        }
    }
}
