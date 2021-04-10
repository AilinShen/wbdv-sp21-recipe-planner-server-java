package com.example.wbdvsp21recipeplannerserverjava.services;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.models.RecipeIngredient;
import com.example.wbdvsp21recipeplannerserverjava.repositories.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeIngredientService {

    @Autowired
    RecipeIngredientRepository repository;

    @Autowired
    RecipeService recipeService;

    public List<RecipeIngredient> findAllRecipeIngredients(){
        return (List<RecipeIngredient>) repository.findAll();
    }

    public void deleteRecipeIngredientById(String id){
        repository.deleteById(Integer.parseInt(id));
    }

    public Integer updateRecipeIngredient(String id, RecipeIngredient newRecipeIngredient){
        if(repository.existsById(Integer.parseInt(id))){
            newRecipeIngredient.setId(Integer.parseInt(id));
            repository.save(newRecipeIngredient);
            return 1;
        }else {
            return -1;
        }
    }

    public RecipeIngredient createRecipeIngredient(String recipeId, RecipeIngredient r){
        try {
            Recipe recipe = recipeService.findRecipeById(recipeId);
            r.setRecipeId(recipeId);

            System.out.println(r);
            return repository.save(r);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public RecipeIngredient findRecipeIngredientById(String id){
        try {
            return (RecipeIngredient) repository.findById(Integer.parseInt(id)).get();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public List<RecipeIngredient> findIngredientsForRecipe(String id){
        System.out.println(id);
        return repository.findIngredientsForRecipe(id);
    }
}
