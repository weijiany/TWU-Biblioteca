package com.twu.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BookTest {

    @Test
    public void show_info() {
        Book book = new Book("1", "book");
        assertThat(book.showInfo()).isEqualTo("id: 1, name: book");
    }
}