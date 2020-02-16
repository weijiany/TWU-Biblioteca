package com.twu.model;

import lombok.Getter;

@Getter
public class Movie {

    private String id;
    private String name;
    private Integer year;
    private String director;
    private Double movieRating;
    private boolean available;

    public Movie() {
    }

    public Movie(String id, String name, Integer year, String director, Double movieRating) {
        this(id, name, year, director, movieRating, true);
    }

    public Movie(String id, String name, Integer year, String director, Double movieRating, boolean available) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.available = available;
    }

    public String showInfo() {
        return String.format("id: %s, name: %s, year: %d, director: %s, movie rating: %s", id, name, year, director, movieRating);
    }

    public void checkout() {
        available = false;
    }
}
