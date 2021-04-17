package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeControllers {

    @Autowired
    RecipeService service;

    @GetMapping("/api/recipes")
    public List<Recipe> findAllRecipes(){
        return service.findAllRecipes();
    }

    // example
//    {
//        "userId": 1,
//            "title": "title",
//            "ingredients": "ingredients",
//            "directions": "directions",
//            "score": 90
//    }
    @PostMapping("/api/recipes")
    public Recipe createRecipe(
            @RequestBody Recipe recipe
    ){
        recipe.setRecipeUniqueId();
        return service.createRecipe(recipe);
    }

    @DeleteMapping("/api/recipes/{rid}")
    public void deleteRecipe(
            @PathVariable("rid") String id
    ){
        service.deleteRecipeById(id);
    }

    @PutMapping("/api/recipes/{rid}")
    public Integer updateRecipe(
            @PathVariable("rid") String id,
            @RequestBody Recipe newRecipe
    ){
        return service.updateRecipe( id, newRecipe);
    }

    @GetMapping("/api/recipes/{rid}")
    public Recipe findAllRecipeById(
            @PathVariable("rid") String id
    ){
        return service.findRecipeById(id);
    }

    @GetMapping("/api/users/{uid}/recipes")
    public List<Recipe> findRecipeForUser(
            @PathVariable("uid") String userId
    ) {
        return service.findRecipesForUser(userId);
    }
}
