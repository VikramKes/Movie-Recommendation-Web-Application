package com.example.movierecommendation.resource;


import com.example.movierecommendation.model.MovieRequest;
import com.example.movierecommendation.model.MovieResponse;
import com.example.movierecommendation.model.UpdateRating;
import com.example.movierecommendation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieResource {
    @Autowired
    MovieService movieService;


    @PostMapping("/movie")
    public ResponseEntity createMovie(@RequestBody MovieRequest movieRequest){
        movieService.create(movieRequest);

        return ResponseEntity.accepted()
                .build();

    }
    @PutMapping("/movie/{movie_id}")
    public ResponseEntity<MovieResponse> updateMovie(@RequestBody UpdateRating updateRating,
                                                     @PathVariable("movie_id") long id ){
        movieService.update(id,updateRating);

        return ResponseEntity.accepted()
                .build();

    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<MovieResponse> getMovie(@PathVariable("movie_id") long id){

        return ResponseEntity
                .ok(movieService.get(id));
    }

    @DeleteMapping("/movie/{movie_id}")
    public ResponseEntity deleteMovie(@PathVariable("movie_id") long id){
        movieService.delete(id);

        return ResponseEntity.accepted()
                .build();

    }

}
