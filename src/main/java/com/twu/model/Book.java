package com.twu.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Book {

    private String id;
    private String name;
    private String author;
    private Integer publishedYear;
    private boolean canCheckout;

    public Book(String id, String name, String author, Integer publishedYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.canCheckout = true;
    }

    public Book(String id, String name, String author, Integer publishedYear, boolean canCheckout) {
        this(id, name, author, publishedYear);
        this.canCheckout = canCheckout;
    }

    public String showInfo() {
        return String.format("id: %s, author: %s, published year: %d, name: %s", id, author, publishedYear, name);
    }

    public boolean canCheckout() {
        return canCheckout;
    }

    public void back() {
        canCheckout = true;
    }

    public void checkout() {
        canCheckout = false;
    }
}
