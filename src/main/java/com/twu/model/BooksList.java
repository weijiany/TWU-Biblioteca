package com.twu.model;

import com.twu.model.exception.NotExistException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BooksList {

    private List<Book> books;

    public BooksList(Book... books) {
        this.books = new ArrayList<>(Arrays.asList(books));
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, books.size())
                .forEach(index -> sb.append(index + 1).append(".").append(books.get(index).showInfo()).append("\n"));

        return sb.toString();
    }

    public void checkout(String bookId) {
        Book book = books.stream()
                .filter(b -> bookId.equals(b.getId())).findFirst()
                .orElseThrow(() -> new NotExistException(bookId));
        books.remove(book);
    }
}
