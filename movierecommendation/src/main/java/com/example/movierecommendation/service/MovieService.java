package com.example.movierecommendation.service;

import com.example.movierecommendation.entity.Movie;
import com.example.movierecommendation.entity.MovieCategory;
import com.example.movierecommendation.model.MovieRequest;
import com.example.movierecommendation.model.MovieResponse;
import com.example.movierecommendation.model.UpdateRating;
import com.example.movierecommendation.respository.MovieCategoryRepository;
import com.example.movierecommendation.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    @Override
    public void create(@RequestBody MovieRequest movieRequest) {
        List<MovieCategory> movieCategories = new ArrayList<>();
        movieRequest
                .getCategories()
                .forEach(cat ->{
                    MovieCategory movieCategory
                            = movieCategoryRepository
                            .findMovieCategoriesByName(cat).get();
                    movieCategories.add(movieCategory);
                });
        Movie movie = Movie
                .builder()
                .name(movieRequest.getName())
                .description(movieRequest.getDesc())
                .movieCategories(movieCategories)
                .build();
        movieRepository.save(movie);
    }

    @Override
    public void update(long id, UpdateRating updateRating) {
        Movie movie = movieRepository.findById(id).get();
        movie.setRating(updateRating.getRating());
        movieRepository.save(movie);

    }

    @Override
    public MovieResponse get(long id) {
        Movie movie = movieRepository.findById(id).get();
        List<String> categories = new ArrayList();
        movie
                .getMovieCategories()
                .forEach(cat ->{
                    categories.add(cat.getName());
                });

        return MovieResponse
                .builder()
                .name(movie.getName())
                .desc(movie.getDescription())
                .rating(movie.getRating())
                .categories(categories)
                .build();
    }

    @Override
    public void delete(long id) {
        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);
    }
}
