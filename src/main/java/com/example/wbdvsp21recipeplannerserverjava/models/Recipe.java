package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Integer userId;
    private String title;
    private String ingredients;
    @OneToMany(targetEntity = RecipeIngredient.class)
    private List<RecipeIngredient> ingredientList;
    private String directions;
    private Integer score;
    private String image;
    private Integer readyInMinutes;



    public Recipe() {
        setRecipeUniqueId();
    }

    public Recipe(Integer userId, String title, String directions, Integer score, String image, Integer readyInMinutes) {
        setRecipeUniqueId();
        this.userId = userId;
        this.title = title;
        this.directions = directions;
        this.score = score;
        this.image = image;
        this.readyInMinutes = readyInMinutes;
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecipeIngredient> getIngredientList() {
        return ingredientList;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public void addIngredient(RecipeIngredient ingredient){
        this.ingredientList.add(ingredient);
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }
}
