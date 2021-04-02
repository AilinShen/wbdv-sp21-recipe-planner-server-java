package com.example.wbdvsp21recipeplannerserverjava.services;
import com.example.wbdvsp21recipeplannerserverjava.models.Review;
import com.example.wbdvsp21recipeplannerserverjava.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ReviewService {
    @Autowired
    ReviewRepository repository;

    public Review CreateReviewForRecipe(Review review) {return repository.save(review);}
    public Review findReviewForRecipe(Long recipeId) { return repository.findReviewForRecipe(recipeId);}
    public Review findReviewForUser(Long userId) { return repository.findReviewForUser(userId);}

    public Integer deleteRecipe(Long rid) {
        repository.deleteById(rid);
        return 1;
    }

}
