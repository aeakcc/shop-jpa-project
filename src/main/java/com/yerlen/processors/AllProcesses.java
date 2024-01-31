package com.yerlen.processors;

import com.yerlen.command.category.CreateCategoryCommand;
import com.yerlen.command.category.ShowAllCategoriesCommand;
import com.yerlen.entity.Category;
import com.yerlen.sort.AscendingSortStrategy;
import com.yerlen.sort.DescendingSortStrategy;
import com.yerlen.sort.SortStrategy;
import com.yerlen.view.View;

import java.util.Scanner;

public class AllProcesses {
    public static final String ASCENDING_SORTING = "1";
    public static final String DESCENDING_SORTING = "2";

    private AllProcesses() {
        throw new RuntimeException("You can not create instance of private constructor");
    }

    private static final Scanner SCANNER = new Scanner(System.in);
    public static void categoryProcess(){
        boolean stillInLoop = true;
        while (stillInLoop) {
            View.showMainMenu();
            String input = SCANNER.nextLine();
            switch (input){
                case "1":
                    View.showCategoryName();
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
                    // TODO: доделать
                    break;
                case "4":
                    // TODO: доделать
                    break;
                case "5":
                    // TODO: доделать
                    break;
                case "6":
                    // TODO: доделать
                    stillInLoop = false;
                    break;
                default:
                    // TODO: переместить во View
                    System.out.println("Wrong value");
            }
        }
    }

    public static SortStrategy sort(){
        View.showSortOption();
        String input = SCANNER.nextLine();
        if(ASCENDING_SORTING.equals(input)) return new AscendingSortStrategy<>();
        if(DESCENDING_SORTING.equals(input)) return new DescendingSortStrategy<>();
        else {
            View.showDefaultSortOption();
            return new AscendingSortStrategy<>();
        }
    }
}
