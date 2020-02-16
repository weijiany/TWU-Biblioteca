package com.twu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoviesList {

    private List<Movie> movies;

    public MoviesList(Movie... movies) {
        this.movies = new ArrayList<>(Arrays.asList(movies));
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder();

        List<Movie> availableMovies = movies.stream().filter(Movie::isAvailable).collect(Collectors.toList());

        IntStream.range(0, availableMovies.size())
                .forEach(index -> sb.append(index + 1).append(".").append(availableMovies.get(index).showInfo()).append("\n"));
        return sb.toString();
    }
}
