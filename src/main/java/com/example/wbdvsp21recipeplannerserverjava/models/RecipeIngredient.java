package com.example.wbdvsp21recipeplannerserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="recipe_ingredients")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer recipeId;
    private String name;
    private Integer amount;
    private String unit;

//    @ManyToOne
//    @JsonIgnore
//    private Recipe recipe;

//    {
//        "recipeId": "rep_123",
//        "name": "cocoa",
//        "amount": "1",
//        "unit": "cup"
//    }

    public RecipeIngredient() {
    }

    public RecipeIngredient(Integer recipeId, String name, Integer amount, String unit) {
        this.recipeId = recipeId;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
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

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }


}

