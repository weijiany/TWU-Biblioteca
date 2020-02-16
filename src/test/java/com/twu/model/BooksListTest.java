package com.twu.model;

import com.twu.model.exception.NotAVailableException;
import com.twu.model.exception.NotAValidReturnException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BooksListTest {

    @Nested
    class Info {
        @Test
        public void show_info() {
            BooksList booksList = new BooksList(new Book("1", "book", "Lucy", 2020));
            assertThat(booksList.showInfo()).isEqualTo("1.id: 1, author: Lucy, published year: 2020, name: book\n");
        }

        @Test
        public void show_info_given_no_books() {
            BooksList booksList = new BooksList();
            assertThat(booksList.showInfo()).isEqualTo("");
        }
    }

    @Nested
    class CheckOut {
        @Test
        public void check_out_a_book() {
            BooksList booksList = new BooksList(new Book("1", "book", "Lucy", 2020));
            booksList.checkout("1");
            assertThat(booksList.showInfo()).isEqualTo("");
        }

        @Test
        public void should_throw_exception_when_check_out_a_book_given_id_not_exist() {
            BooksList booksList = new BooksList(new Book("1", "book", "Lucy", 2020));
            String id = "not exist";
            assertThatThrownBy(() -> booksList.checkout(id))
                    .isInstanceOf(NotAVailableException.class)
                    .hasMessage(NotAVailableException.MESSAGE);
        }
    }

    @Nested
    class Return {
        @Test
        public void return_a_bok() {
            BooksList booksList = new BooksList(new Book("1", "book", "Lucy", 2020, false));
            booksList.returnABook("1");
            assertThat(booksList.showInfo()).isEqualTo("1.id: 1, author: Lucy, published year: 2020, name: book\n");
        }

        @Test
        public void should_throw_exception_when_return_a_book_given_id_is_invalid() {
            BooksList booksList = new BooksList(new Book("1", "book", "Lucy", 2020));
            String id = "invalid id";
            assertThatThrownBy(() -> booksList.returnABook(id))
                    .isInstanceOf(NotAValidReturnException.class)
                    .hasMessage(NotAValidReturnException.MESSAGE);
        }
    }
}