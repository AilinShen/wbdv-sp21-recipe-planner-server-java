package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Review;
import com.example.wbdvsp21recipeplannerserverjava.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReviewControllers {
    @Autowired
    ReviewService service;

    @GetMapping("/api/reviews")
    public List<Review> findAllReviews(){
        return service.findAllReviews();
    }

    @PostMapping("/api/recipes/{rid}/reviews")
    public Review createReview(
            @PathVariable("rid") String recipeId,
            @RequestBody Review review
    ) {
        review.setRecipeId(recipeId);
        return service.CreateReview(review);
    }

    @GetMapping("/api/users/{uid}/reviews")
    public List<Review> findReviewForUser(
            @PathVariable("uid") Long userId
    ) {
        return service.findReviewForUser(userId);
    }

    @GetMapping("/api/recipes/{rid}/reviews")
    public List<Review> findReviewForRecipe(
            @PathVariable("rid") String recipeId
    ) {
        return service.findReviewForRecipe(recipeId);
    }
}
