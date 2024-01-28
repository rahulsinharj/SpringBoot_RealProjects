package com.movieshoutreview.model.bo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movieshoutreview.model.dto.response.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Data
@Entity
@Table(name = "review_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String movieReview;

    private double rating;              // rating dedicated to each review

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnore
    private Movie movie;        // It will add foreign key in mysql table with <TABLE_NAME>_<ID_NAME> --> //

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    public static ReviewResponse toReviewResponse(Review review) {
        return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList) {
        if (Objects.isNull(reviewList))
            return new ArrayList<>();
        else
            return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
    }
}
