package com.twu.model;

import com.twu.model.exception.NotAVailableException;
import com.twu.model.exception.NotAValidReturnException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BooksList {

    private List<Book> books;

    public BooksList(Book... books) {
        this.books = new ArrayList<>(Arrays.asList(books));
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder();
        List<Book> canCheckoutBooks = books.stream()
                .filter(Book::canCheckout)
                .collect(Collectors.toList());
        IntStream.range(0, canCheckoutBooks.size())
                .forEach(index -> sb.append(index + 1).append(".").append(canCheckoutBooks.get(index).showInfo()).append("\n"));

        return sb.toString();
    }

    public void checkout(String bookId) {
        Book book = books.stream()
                .filter(b -> bookId.equals(b.getId())).findFirst()
                .orElseThrow(NotAVailableException::new);
        book.checkout();
    }

    public void returnABook(String bookId) {
        books.stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElseThrow(NotAValidReturnException::new)
                .back();
    }
}
