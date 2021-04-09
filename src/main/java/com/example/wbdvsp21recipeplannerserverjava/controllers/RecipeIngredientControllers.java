package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.models.RecipeIngredient;
import com.example.wbdvsp21recipeplannerserverjava.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeIngredientControllers {

    @Autowired
    RecipeIngredientService service;

    @GetMapping("/api/recipe-ingredients")
    public List<RecipeIngredient> findAllRecipeIngredients(){
        return service.findAllRecipeIngredients();
    }

    @DeleteMapping("/api/recipe-ingredients/{id}")
    public void deleteRecipeIngredient(
            @PathVariable("id") String id
    ){
        service.deleteRecipeIngredientById(id);
    }

    @PutMapping("/api/recipe-ingredients/{id}")
    public Integer updateRecipeIngredient(
            @PathVariable("id") String id,
            @RequestBody RecipeIngredient r
    ){
       return service.updateRecipeIngredient(id, r);
    }

    @PostMapping("/api/recipe-ingredients")
    public RecipeIngredient createRecipeIngredient(
            @RequestBody RecipeIngredient r
    ){
        return service.createRecipeIngredient(r);
    }

    @GetMapping("/api/recipe-ingredients/{id}")
    public RecipeIngredient updateRecipeIngredient(
            @PathVariable("id") String id
    ){
        return service.findRecipeIngredientById(id);
    }

}
