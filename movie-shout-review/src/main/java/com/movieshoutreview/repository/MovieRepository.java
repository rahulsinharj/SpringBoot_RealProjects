package com.movieshoutreview.repository;

import com.movieshoutreview.model.bo.Genre;
import com.movieshoutreview.model.bo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Movie findByTitle(String title);

    public Movie findByTitleContaining(String title);

    public List<Movie> findByGenre(Genre genre);

}