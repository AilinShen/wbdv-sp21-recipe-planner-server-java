package com.example.wbdvsp21recipeplannerserverjava.services;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository repository;


    public Recipe createRecipe(Recipe recipe){
        return repository.save(recipe);
    }

    public List<Recipe> findAllRecipes(){
        return (List<Recipe>) repository.findAll();
    }

    public void deleteRecipeById(String id) {
        repository.deleteById(id);
    }

    public Integer updateRecipe(String recipeId, Recipe newRecipe){
        if (repository.existsById(recipeId)){
            newRecipe.setId(recipeId);
            System.out.println(newRecipe.getId());
            repository.save(newRecipe);
            return 1;
        }else {
            return -1;
        }
    }

    public Recipe findRecipeById(String id){
        try {
            return (Recipe) repository.findById(id).get();
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
