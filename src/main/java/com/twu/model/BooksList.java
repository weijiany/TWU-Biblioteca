package com.twu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BooksList {

    private List<Book> books;


    public BooksList(Book... books) {
        this.books = Arrays.asList(books);
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, books.size())
                .forEach(index -> sb.append(index + 1).append(".").append(books.get(index).showInfo()).append("\n"));

        return sb.toString();
    }
}
