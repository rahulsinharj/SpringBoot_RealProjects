package com.movieshoutreview.service;


import com.movieshoutreview.model.bo.Movie;
import com.movieshoutreview.model.bo.Review;
import com.movieshoutreview.model.dto.response.ReviewResponse;
import com.movieshoutreview.repository.MovieRepository;
import com.movieshoutreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);

        //need to optimized
        //exception handling.
        if (movie != null) {
            reviewRepository.save(review);

            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        } else throw new NoSuchElementException();
    }

    public ReviewResponse getReviewById(Long reviewId) {

        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.map(Review::toReviewResponse).orElse(null);

    }
}