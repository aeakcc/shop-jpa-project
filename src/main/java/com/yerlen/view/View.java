package com.yerlen.view;

public class View {
    private View() {
    }

    public static void showCategoryMenu() {
        System.out.println("""
                1.Create new category
                2.Show all categories
                3.Go inside option
                4.Go inside product
                5.Go inside value
                6.Exit
                """);
    }

    public static void showOptionMenu() {
        System.out.println("""
                1.Create new option
                2.Show all options
                3.Go inside category
                4.Go inside product
                5.Go inside value
                6.Exit
                """);
    }

    public static void showProductMenu() {
        System.out.println("""
                1.Create new product
                2.Show all products
                3.Go inside category
                4.Go inside option
                5.Go inside value
                6.Exit
                """);
    }

    public static void showValueMenu(){
        System.out.println("""
                1.Create new value
                2.Show all values
                3.Go inside category
                4.Go inside option
                5.Go inside prodcut
                6.Exit
                """);
    }

    public static void showCategoryName() {
        System.out.println("Name of category");
    }
    public static void showOptionName() {
        System.out.println("Name of option");
    }
    public static void showProductName() {
        System.out.println("Name of product");
    }
    public static void showProductPrice(){
        System.out.println("Price of product");
    }
    public static void showValueName() {
        System.out.println("Name of value");
    }

    public static void showSortOption() {
        System.out.println("1.Sort by ascending");
        System.out.println("2.Sort by descending");
    }

    public static void showDefaultSortOption() {
        System.out.println("Wrong value, by default it will sort by ascending");
    }

    public static void showWrongValue(){
        System.out.println("Wrong value");
    }

    public static void showCreateCategory(String categoryName){
        System.out.println("Success, new category " + categoryName + " was created");
    }
    public static void showCreateOption(String optionName){
        System.out.println("Success, new option " + optionName + " was created");
    }

    public static void showCreateProduct(String productName){
        System.out.println("Success, new product " + productName + " was created");
    }

    public static void showCreateValue(String valueName){
        System.out.println("Success, new value " + valueName + " was created");
    }
}
