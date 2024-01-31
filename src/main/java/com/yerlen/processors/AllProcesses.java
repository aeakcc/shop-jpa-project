package com.yerlen.processors;

import com.yerlen.command.category.CreateCategoryCommand;
import com.yerlen.command.category.ShowAllCategoriesCommand;
import com.yerlen.entity.Category;
import com.yerlen.sort.AscendingSortStrategy;
import com.yerlen.sort.DescendingSortStrategy;
import com.yerlen.sort.SortStrategy;

import java.util.Scanner;

public class AllProcesses {
    private static final Scanner SCANNER = new Scanner(System.in);
    public void categoryProcess(){
        boolean stillInLoop = true;
        while (stillInLoop) {
            System.out.println("""
                    1.Create new category
                    2.Show all categories
                    3.Go inside option
                    4.Go inside product
                    5.Go inside value
                    6.Exit
                    """);
            String input = SCANNER.nextLine();
            switch (input){
                case "1":
                    System.out.println("Name of category");
                    input = SCANNER.nextLine();
                    CreateCategoryCommand create = new CreateCategoryCommand(input);
                    create.execute();
                    break;
                case "2":
                    SortStrategy<Category> sortStrategy = sort();
                    ShowAllCategoriesCommand categoriesCommand = new ShowAllCategoriesCommand(sortStrategy);
                    categoriesCommand.execute();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    stillInLoop = false;
                    break;
                default:
                    System.out.println("Wrong value");
            }
        }
    }

    public SortStrategy sort(){
        System.out.println("1.Sort by ascending");
        System.out.println("2.Sort by descending");
        String input = SCANNER.nextLine();
        if("1".equals(input)) return new AscendingSortStrategy<>();
        if("2".equals(input)) return new DescendingSortStrategy<>();
        else {
            System.out.println("Wrong value, by default it will sort by ascending");
            return new AscendingSortStrategy<>();
        }
    }
}
