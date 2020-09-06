package com.example.movierecommendation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class MovieCategory  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false, unique = true)
    String name;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Movie> movieList;

    public MovieCategory() {
    }

    public MovieCategory(String name) {
        this.name = name;
    }

    public MovieCategory(String name, List<Movie> movieList) {
        this.name = name;
        this.movieList = movieList;
    }

    public MovieCategory(long id , String name, List<Movie> movieList) {
        this.id=id;
        this.name = name;
        this.movieList = movieList;
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

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
