package com.twu.model;

import lombok.Getter;

@Getter
public class Book {

    private String id;
    private String name;

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String showInfo() {
        return String.format("id: %s, name: %s", id, name);
    }
}
