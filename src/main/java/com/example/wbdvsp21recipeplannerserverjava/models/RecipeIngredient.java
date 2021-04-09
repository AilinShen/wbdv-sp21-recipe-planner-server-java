package com.example.wbdvsp21recipeplannerserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="recipe_ingredients")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer amount;
    private String unit;
    private String recipeId;


//    {
//        "recipeId": "rep_123",
//        "name": "cocoa",
//        "amount": "1",
//        "unit": "cup"
//    }

    public RecipeIngredient() {
    }

    public RecipeIngredient(String name, Integer amount, String unit, String recipeId) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.recipeId = recipeId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }
}

