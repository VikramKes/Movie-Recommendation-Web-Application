package com.example.movierecommendation.service;


import com.example.movierecommendation.model.MovieRequest;
import com.example.movierecommendation.model.MovieResponse;
import com.example.movierecommendation.model.UpdateRating;

public interface IMovieService {
    void create(MovieRequest movieRequest);
    void update(long id, UpdateRating updateRating);
    MovieResponse get(long id);
    void delete( long id);
}
