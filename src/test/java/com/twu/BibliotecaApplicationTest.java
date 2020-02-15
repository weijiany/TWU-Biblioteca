package com.twu;

import com.twu.model.BooksList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

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
        assertThat(mockOutPut.toString()).contains(BibliotecaApplication.LIST_OF_BOOKS);
    }

    @Test
    void invalid_option() {
        provideInSteam("invalid option");

        BibliotecaApplication.welcome();

        assertThat(mockOutPut.toString()).contains("Please select a valid selection.");
    }

    @Test
    void list_all_of_books() {
        provideInSteam("1");
        BooksList mockBooksList = mock(BooksList.class);
        BibliotecaApplication.booksList = mockBooksList;

        BibliotecaApplication.welcome();

        verify(mockBooksList, times(1)).showInfo();
    }
}