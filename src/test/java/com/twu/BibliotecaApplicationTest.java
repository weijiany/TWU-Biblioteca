package com.twu;

import com.twu.model.BooksList;
import com.twu.model.MoviesList;
import com.twu.model.exception.NotAVailableException;
import com.twu.model.exception.NotAValidReturnException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BibliotecaApplicationTest {

    private ByteArrayOutputStream mockOutPut;

    @BeforeEach
    public void beforeEach() {
        mockOutPut = new ByteArrayOutputStream();
        ConsoleUtil.out = new PrintStream(mockOutPut);
        provideInSteam("1");
    }

    @AfterEach
    public void afterEach() {
        mockOutPut = new ByteArrayOutputStream();
    }

    private void provideInSteam(String str) {
        ConsoleUtil.scanner = new Scanner(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    void welcome_and_menu() {
        BibliotecaApplication.welcome();

        assertThat(mockOutPut.toString()).contains(BibliotecaApplication.WELCOME);
        assertThat(mockOutPut.toString()).contains(BibliotecaApplication.MENU);
    }

    @Test
    void invalid_option() {
        provideInSteam("invalid option");

        BibliotecaApplication.welcome();

        assertThat(mockOutPut.toString()).contains(BibliotecaApplication.SELECT_ERR_OPTION);
    }

    @Nested
    class Book {
        @Test
        void list_all_of_books() {
            provideInSteam("1");
            BooksList mockBooksList = mock(BooksList.class);
            BibliotecaApplication.booksList = mockBooksList;

            BibliotecaApplication.welcome();

            verify(mockBooksList, times(1)).showInfo();
        }

        @Test
        void check_out_a_book() {
            provideInSteam("2\n1");
            BooksList mockBooksList = mock(BooksList.class);
            BibliotecaApplication.booksList = mockBooksList;

            BibliotecaApplication.welcome();

            verify(mockBooksList, times(1)).checkout("1");
            assertThat(mockOutPut.toString()).contains(BibliotecaApplication.CHECK_OUT_SUCCESSFULLY);
        }

        @Test
        void check_out_a_not_exist_book() {
            provideInSteam("2\n1");
            BooksList mockBooksList = mock(BooksList.class);
            BibliotecaApplication.booksList = mockBooksList;
            doThrow(new NotAVailableException()).when(mockBooksList).checkout(anyString());

            BibliotecaApplication.welcome();

            assertThat(mockOutPut.toString()).contains(NotAVailableException.MESSAGE);
        }

        @Test
        void return_a_exist_book() {
            provideInSteam("3\n1");
            BooksList mockBooksList = mock(BooksList.class);
            BibliotecaApplication.booksList = mockBooksList;

            BibliotecaApplication.welcome();

            verify(mockBooksList, times(1)).returnABook("1");
            assertThat(mockOutPut.toString()).contains(BibliotecaApplication.RETURN_SUCCESSFULLY);
        }

        @Test
        void return_a_invalid_book() {
            provideInSteam("3\n1");
            BooksList mockBooksList = mock(BooksList.class);
            BibliotecaApplication.booksList = mockBooksList;
            doThrow(new NotAValidReturnException()).when(mockBooksList).returnABook(anyString());

            BibliotecaApplication.welcome();

            assertThat(mockOutPut.toString()).contains(NotAValidReturnException.MESSAGE);
        }
    }

    @Nested
    class Movie {
        @Test
        void list_all_of_movie() {
            provideInSteam("4");
            MoviesList mockMoviesList = mock(MoviesList.class);
            BibliotecaApplication.moviesList = mockMoviesList;

            BibliotecaApplication.welcome();

            verify(mockMoviesList, times(1)).showInfo();
        }
    }
}