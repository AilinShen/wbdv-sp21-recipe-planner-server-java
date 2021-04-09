package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    private String id;
    private Integer userId;
    private String title;
    private String ingredients;
    private String directions;
    private Integer score;
    private String imageUrl;



    public Recipe() {
    }

    public Recipe(Integer userId, String title, String ingredients, String directions, Integer score, String imageUrl) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.userId = userId;
        this.title = title;
        this.ingredients = ingredients;
        this.directions = directions;
        this.score = score;
        this.imageUrl = imageUrl;
    }

    public void setRecipeUniqueId(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.setId("rcp_"+ uuid);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
