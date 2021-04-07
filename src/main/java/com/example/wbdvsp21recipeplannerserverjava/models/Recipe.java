package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String apiRecipeId;
    private String title;
    private String ingredients;
    private String directions;
    private Integer score;

    public Recipe() {
    }

    public Recipe(String apiRecipeId, String title, String ingredients, String directions, Integer score) {
        this.apiRecipeId = apiRecipeId;
        this.title = title;
        this.ingredients = ingredients;
        this.directions = directions;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApiRecipeId() {
        return apiRecipeId;
    }

    public void setApiRecipeId(String apiRecipeId) {
        this.apiRecipeId = apiRecipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
