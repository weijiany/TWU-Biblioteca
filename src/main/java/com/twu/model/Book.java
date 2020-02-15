package com.twu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {

    private String id;
    private String name;
    private String author;
    private Integer publishedYear;

    public String showInfo() {
        return String.format("id: %s, author: %s, published year: %d, name: %s", id, author, publishedYear, name);
    }
}
