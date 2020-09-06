package com.example.movierecommendation.respository;

import com.example.movierecommendation.entity.MovieCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieCategoryRepository extends CrudRepository<MovieCategory,Long> {
//    @Query("select movieCategory from MovieCategory movieCategory " +
//            "where movieCategory.name = name")
    Optional<MovieCategory> findMovieCategoriesByName(String name);
}
