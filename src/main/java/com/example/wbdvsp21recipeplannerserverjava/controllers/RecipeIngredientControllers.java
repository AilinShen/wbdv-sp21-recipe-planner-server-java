package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.models.RecipeIngredient;
import com.example.wbdvsp21recipeplannerserverjava.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeIngredientControllers {

    @Autowired
    RecipeIngredientService service;

    @GetMapping("/api/ingredients")
    public List<RecipeIngredient> findAllIngredients(){
        return service.findAllRecipeIngredients();
    }


    @DeleteMapping("/api/ingredients/{id}")
    public void deleteIngredient(
            @PathVariable("id") Integer id
    ){
        service.deleteRecipeIngredientById(id);
    }

    @PutMapping("/api/ingredients/{id}")
    public Integer updateIngredient(
            @PathVariable("id") Integer id,
            @RequestBody RecipeIngredient r
    ){
       return service.updateRecipeIngredient(id, r);
    }

    @GetMapping("/api/ingredients/{id}")
    public RecipeIngredient findIngredientById(
            @PathVariable("id") Integer id
    ){
        return service.findRecipeIngredientById(id);
    }


    //For each recipe

    @GetMapping("/api/recipes/{recipeId}/ingredients")
    public List<RecipeIngredient> findIngredientsForRecipe(
            @PathVariable("recipeId") String recipeId){
        return service.findIngredientsForRecipe(recipeId);
    }


    @PostMapping("/api/recipes/{rid}/ingredients")
    public RecipeIngredient createRecipeIngredient(
            @PathVariable("rid") String recipeId,
            @RequestBody RecipeIngredient ri
    ){
        return service.createRecipeIngredient(recipeId, ri);
    }




}
