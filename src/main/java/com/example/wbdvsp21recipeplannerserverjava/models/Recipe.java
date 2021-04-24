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
    private String directions;
    private String image;
    private Integer readyInMinutes;
    @OneToMany(targetEntity = RecipeIngredient.class, cascade = CascadeType.DETACH)
    private List<RecipeIngredient> extendedIngredients;



    public Recipe() {
        setRecipeUniqueId();
    }

    public Recipe(Integer userId, String title, String directions, String image, Integer readyInMinutes) {
        setRecipeUniqueId();
        this.userId = userId;
        this.title = title;
        this.directions = directions;
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

    public List<RecipeIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(List<RecipeIngredient> ingredientList) {
        this.extendedIngredients = ingredientList;
    }

    public void addIngredient(RecipeIngredient ingredient){
        this.extendedIngredients.add(ingredient);
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
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
