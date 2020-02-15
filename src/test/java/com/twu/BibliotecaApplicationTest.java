package com.twu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class BibliotecaApplicationTest {

    private ByteArrayOutputStream mockOutPut;

    @BeforeEach
    public void beforeEach() {
        mockOutPut = new ByteArrayOutputStream();
        ConsoleUtil.out = new PrintStream(mockOutPut);
    }

    @AfterEach
    public void afterEach() {
        mockOutPut = new ByteArrayOutputStream();
    }

    private void provideInSteam(String str) {
        ConsoleUtil.scanner = new Scanner(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    void welcome() {
        BibliotecaApplication.welcome();

        assertThat(mockOutPut.toString()).contains(BibliotecaApplication.WELCOME);
    }

    @Test
    void menu() {
        BibliotecaApplication.welcome();

        assertThat(mockOutPut.toString()).contains(BibliotecaApplication.LIST_OF_BOOKS);
    }

    @Test
    void invalid_option() {
        provideInSteam("invalid option");

        BibliotecaApplication.welcome();

        assertThat(mockOutPut.toString()).contains("Please select a valid selection.");
    }
}