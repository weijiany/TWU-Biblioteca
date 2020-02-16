package com.twu.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoviesListTest {

    @Nested
    class Info {
        @Test
        public void show_info() {
            MoviesList moviesList = new MoviesList(
                    new Movie("1", "movie", 2020, "Lucy", 9.1),
                    new Movie("1", "movie", 2020, "Lucy", 9.1, false)
            );
            assertThat(moviesList.showInfo()).isEqualTo("1.id: 1, name: movie, year: 2020, director: Lucy, movie rating: 9.1\n");
        }
    }

    @Nested
    class Checkout {
        @Test
        public void check_out_a_book() {
            MoviesList moviesList = new MoviesList(new Movie("1", "movie", 2020, "Lucy", 9.1));
            moviesList.checkout("1");
            assertThat(moviesList.showInfo()).isEqualTo("");
        }
    }
}