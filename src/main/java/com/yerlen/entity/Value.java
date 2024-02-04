package com.yerlen.entity;

import com.yerlen.command.value.CreateValueCommand;
import com.yerlen.command.value.ShowAllValueCommand;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Process;
import com.yerlen.view.View;
import jakarta.persistence.*;

import static com.yerlen.processors.AllProcesses.SCANNER;
import static com.yerlen.processors.AllProcesses.sort;
import static com.yerlen.processors.Start.ENTITY_MANAGER;

@Entity
@Table(name = "values")
public class Value implements Comparable<Value>, Process {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "options_id")
    private Option options;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

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

    @Override
    public int compareTo(Value o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public void processEntity() {
        boolean stillInLoop = true;
        while (stillInLoop) {
            View.showValueMenu();
            String input = SCANNER.nextLine();
            switch (input) {
                case "1":
                    View.showValueName();
                    input = SCANNER.nextLine();

                    System.out.println("For which option are you creating value");
                    String optionName = SCANNER.nextLine();
                    String optionQuery = "SELECT o FROM Option o WHERE o.name = :name";
                    TypedQuery<Option> opyionTypedQuery = ENTITY_MANAGER.createQuery(optionQuery, Option.class);
                    opyionTypedQuery.setParameter("name", optionName);
                    Option option = opyionTypedQuery.getSingleResult();

                    System.out.println("For which product are you creating value");
                    String productName = SCANNER.nextLine();
                    String productQuery = "SELECT p FROM Product p WHERE p.name = :name";
                    TypedQuery<Product> productTypedQuery = ENTITY_MANAGER.createQuery(productQuery, Product.class);
                    productTypedQuery.setParameter("name", productName);
                    Product product = productTypedQuery.getSingleResult();

                    if (!product.getId().equals(option.getId())) {
                        System.out.println("They are not in the same category, you can not create it");
                        break;
                    }

                    CreateValueCommand create = new CreateValueCommand(input, option, product);
                    create.execute();
                    break;
                case "2":
                    SortStrategy sortStrategy = sort();
                    ShowAllValueCommand showAllValueCommand = new ShowAllValueCommand(sortStrategy);
                    showAllValueCommand.execute();
                    break;
                case "3":
                    new Category().processEntity();
                    break;
                case "4":
                    new Option().processEntity();
                    break;
                case "5":
                    new Product().processEntity();
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
