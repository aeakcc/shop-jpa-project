package com.yerlen.view;

public class View {
    private View() {
    }

    public static void showMainMenu() {
        System.out.println("""
                1.Create new category
                2.Show all categories
                3.Go inside option
                4.Go inside product
                5.Go inside value
                6.Exit
                """);
    }

    public static void showCategoryName() {
        System.out.println("Name of category");
    }

    public static void showSortOption() {
        System.out.println("1.Sort by ascending");
        System.out.println("2.Sort by descending");
    }

    public static void showDefaultSortOption() {
        System.out.println("Wrong value, by default it will sort by ascending");
    }
}
