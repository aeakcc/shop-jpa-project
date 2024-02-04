package com.yerlen.processors;

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

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void startProcess() {
        Category category = new Category();
        category.processEntity();
    }

    public static SortStrategy sort() {
        View.showSortOption();
        String input = SCANNER.nextLine();
        if (ASCENDING_SORTING.equals(input)) return new AscendingSortStrategy<>();
        if (DESCENDING_SORTING.equals(input)) return new DescendingSortStrategy<>();
        else {
            View.showDefaultSortOption();
            return new AscendingSortStrategy<>();
        }
    }
}
