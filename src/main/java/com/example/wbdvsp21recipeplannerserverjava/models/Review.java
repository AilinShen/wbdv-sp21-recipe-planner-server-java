package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String recipeId;
    private String text;
    private String recipeName;
    @ManyToOne(targetEntity = User.class)
    private User reviewUser;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Review() {
    }

    public Review(Long reviewId, User user, String recipeId, String text) {
        this.reviewId = reviewId;
        this.reviewUser = user;
        this.recipeId = recipeId;
        this.text = text;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public User getUser() {
        return reviewUser;
    }

    public void setUser(User user) {
        this.reviewUser = user;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
