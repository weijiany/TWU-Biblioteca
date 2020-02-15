package com.twu.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BooksListTest {

    @Test
    public void show_info() {
        BooksList booksList = new BooksList(new Book("1", "book"));
        assertThat(booksList.showInfo()).isEqualTo("1.id: 1, name: book\n");
    }
}