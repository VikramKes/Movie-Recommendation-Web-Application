package com.example.movierecommendation.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Builder
@Data
@NoArgsConstructor
@Table(name = "movie")
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "movie_name", nullable = false, unique = true)
    String name;

    @Column(name = "description", nullable = true)
    String description;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "movie_movie_category",
                    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
            )
    List<MovieCategory> movieCategories;
    @Column(name = "rating")
    int rating;

    public Movie(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MovieCategory> getMovieCategories() {
        return movieCategories;
    }

    public void setMovieCategories(List<MovieCategory> movieCategories) {
        this.movieCategories = movieCategories;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
