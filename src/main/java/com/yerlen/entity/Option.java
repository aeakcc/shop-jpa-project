package com.yerlen.entity;

import com.yerlen.command.option.CreateOptionCommand;
import com.yerlen.command.option.ShowAllOptionCommand;
import com.yerlen.sort.SortStrategy;
import com.yerlen.util.Process;
import com.yerlen.view.View;
import jakarta.persistence.*;

import java.util.List;

import static com.yerlen.processors.AllProcesses.SCANNER;
import static com.yerlen.processors.AllProcesses.sort;
import static com.yerlen.processors.Start.ENTITY_MANAGER;

@Entity
@Table(name = "options")
public class Option implements Comparable<Option>, Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "options")
    private List<Value> values;

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

    @Override
    public int compareTo(Option o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public void processEntity() {
        boolean stillInLoop = true;
        while (stillInLoop) {
            View.showOptionMenu();
            String input = SCANNER.nextLine();
            switch (input) {
                case "1":
                    View.showOptionName();
                    input = SCANNER.nextLine();
                    System.out.println("For which category you creating option");

                    String categoryName = SCANNER.nextLine();
                    String query = "SELECT c FROM Category c WHERE c.name = :name";
                    TypedQuery<Category> typedQuery = ENTITY_MANAGER.createQuery(query, Category.class);
                    typedQuery.setParameter("name", categoryName);

                    Category category = typedQuery.getSingleResult();
                    CreateOptionCommand create = new CreateOptionCommand(input, category);
                    create.execute();
                    break;
                case "2":
                    SortStrategy sortStrategy = sort();
                    ShowAllOptionCommand showAllOptionCommand = new ShowAllOptionCommand(sortStrategy);
                    showAllOptionCommand.execute();
                    break;
                case "3":
                    new Category().processEntity();
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