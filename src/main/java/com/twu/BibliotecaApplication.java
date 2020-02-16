package com.twu;

import com.twu.model.BooksList;
import com.twu.model.exception.DomainException;

public class BibliotecaApplication {

    public final static String LIST_OF_BOOKS = "List of books.";
    public final static String CHECK_OUT_BOOK = "Check-out a book.";
    public final static String RETURN_BOOK = "Return a book.";
    public final static String EXIT = "Exit";
    public final static String MENU = "================MENU================\n1. " +
            LIST_OF_BOOKS + "\n2." + CHECK_OUT_BOOK + "\n3." + RETURN_BOOK +
            "\n4" + EXIT;
    public final static String WELCOME = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String CHECK_OUT_SUCCESSFULLY = "Thank you! Enjoy the book.";
    public static final String RETURN_SUCCESSFULLY = "Thank you for returning the book.";
    public static String SELECT_ERR_OPTION = "Please select a valid selection.";
    public static BooksList booksList = new BooksList();

    public static void main(String[] args) {
        welcome();
    }

    public static void welcome() {
        ConsoleUtil.println(WELCOME);
        ConsoleUtil.println(MENU);

        String option = ConsoleUtil.next();


        try {
            switch (option) {
                case "1":
                    booksList.showInfo();
                    break;
                case "2":
                    booksList.checkout(ConsoleUtil.next());
                    ConsoleUtil.println(CHECK_OUT_SUCCESSFULLY);
                    break;
                case "3":
                    booksList.returnABook(ConsoleUtil.next());
                    ConsoleUtil.println(RETURN_SUCCESSFULLY);
                    break;
                case "4":
                    System.exit(0);
                default:
                    ConsoleUtil.println(SELECT_ERR_OPTION);
            }
        } catch (DomainException e) {
            ConsoleUtil.println(e.getMessage());
        }
    }
}
