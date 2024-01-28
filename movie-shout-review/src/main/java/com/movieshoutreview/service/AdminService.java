package com.movieshoutreview.service;

import com.movieshoutreview.model.bo.Movie;
import com.movieshoutreview.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    //constructor injection
    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}