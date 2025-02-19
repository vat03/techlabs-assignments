package com.aurionpro.model;

import java.io.*;
import java.util.*;

public class MovieManager {
    private List<Movie> movies;
    private static final String filePath = "data.bin";
    private static final int Max_Movies = 5;

    public MovieManager() {
        movies = new ArrayList<>(); 
        loadMovies();
    }

    // Method to add movies
    public void addMovie(Movie movie) {
        if (movies.size() < Max_Movies) {
            movies.add(movie);
            saveMovies();
            System.out.println("Movie added successfully.");
            return;
        }
        System.out.println("Maximum " + Max_Movies + " movies can be added!!");
    }

    // Method to clear movies from the list but still present in the file
    public void clearMovies() {
        movies.clear();
    }

    // Method to get all movies
    public List<Movie> getMovies() {
        return movies;
    }

    // Method to get movie id
    public int getMovieId() {
        return movies.size() + 1;
    }

    // Deserialization
    public void loadMovies() {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            movies = (List<Movie>) objectInputStream.readObject();
            System.out.println("Movies loaded: " + movies.size() + " movies found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading movies: " + e.getMessage());
        }
    }

    // Serialization
    public void saveMovies() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(movies);
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }

    // Method to delete all the movies from the list as well as the file itself
    public void deleteAllMovies() {
        File file = new File(filePath);
        if (file.exists() && file.delete()) {
            System.out.println("All movies deleted successfully from the file.");
        }
        movies.clear();
    }
}
