package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository
extends CrudRepository<Review, Long>{
    @Query(value="SELECT * FROM reviews where recipe_id=:rid", nativeQuery = true)
    public List<Review> findReviewForRecipe(@Param("rid") String recipeId);

    @Query(value="SELECT * FROM reviews WHERE review_user_id=:uid", nativeQuery = true)
    public List<Review> findReviewForUser(@Param("uid") Long userId);
}
