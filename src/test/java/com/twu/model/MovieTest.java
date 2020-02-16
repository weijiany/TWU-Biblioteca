package com.twu.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {

    @Test
    public void show_info() {
        Movie movie = new Movie("1", "movie", 2020, "Lucy", 9.1);

        assertThat(movie.showInfo()).isEqualTo("id: 1, name: movie, year: 2020, director: Lucy, movie rating: 9.1");
    }
}