package com.movieshoutreview.model.bo;

import com.movieshoutreview.model.dto.response.MovieResponse;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating;              // A single entity which is average rating of all review for a movie.

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public MovieResponse toMovieResponse() {
        return MovieResponse.builder()
                .genre(this.genre)
                .title(this.title)
                .rating(this.rating)
                .reviews(Review.toReviewResponse(this.reviews))
                .build();
    }


}
