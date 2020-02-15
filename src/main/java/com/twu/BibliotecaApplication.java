package com.twu;

public class BibliotecaApplication {

    public final static String LIST_OF_BOOKS = "List of books.";
    public final static String MENU = "================MENU================\n1. " + LIST_OF_BOOKS;
    public final static String WELCOME = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public static void main(String[] args) {
        welcome();
    }

    public static void welcome() {
        ConsoleUtil.println(WELCOME);
        ConsoleUtil.println(MENU);
    }
}
