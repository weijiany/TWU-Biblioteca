package com.twu.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BooksListTest {

    @Test
    public void show_info() {
        BooksList booksList = new BooksList(new Book("1", "book", "Lucy", 2020));
        assertThat(booksList.showInfo()).isEqualTo("1.id: 1, author: Lucy, published year: 2020, name: book\n");
    }
}