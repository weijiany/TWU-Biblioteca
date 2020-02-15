package com.twu;

public class BibliotecaApplication {

    public final static String LIST_OF_BOOKS = "List of books.";
    public final static String MENU = "================MENU================\n1. " + LIST_OF_BOOKS;
    public final static String WELCOME = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private static String SELECT_ERR_OPTION = "Please select a valid selection.";

    public static void main(String[] args) {
        welcome();
    }

    public static void welcome() {
        ConsoleUtil.println(WELCOME);
        ConsoleUtil.println(MENU);

        String option = ConsoleUtil.next();

        try {
            if (option.isEmpty() || Integer.parseInt(option) != 1)
                ConsoleUtil.println(SELECT_ERR_OPTION);
        } catch (NumberFormatException e) {
            ConsoleUtil.println(SELECT_ERR_OPTION);
        }
    }
}
