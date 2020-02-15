package com.twu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    void welcome() {
        BibliotecaApplication.welcome();

        assertThat(mockOutPut.toString()).contains(BibliotecaApplication.WELCOME);
    }
}