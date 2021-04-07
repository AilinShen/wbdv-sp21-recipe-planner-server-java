package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="recipe_ingredients")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer recipeId;
    private Integer ingredientId;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Integer recipeId, Integer ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }
}

