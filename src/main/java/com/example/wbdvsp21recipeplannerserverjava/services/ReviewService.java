package com.example.wbdvsp21recipeplannerserverjava.services;
import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.models.Review;
import com.example.wbdvsp21recipeplannerserverjava.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository repository;

    public Review CreateReview(Review review) {return repository.save(review);}
    public List<Review> findAllReviews(){
        return (List<Review>) repository.findAll();

    }
    public List<Review> findReviewForRecipe(String recipeId) { return repository.findReviewForRecipe(recipeId);}
    public List<Review> findReviewForUser(Long userId) { return repository.findReviewForUser(userId);}
}
