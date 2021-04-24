package com.example.wbdvsp21recipeplannerserverjava.services;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import com.example.wbdvsp21recipeplannerserverjava.models.RecipeIngredient;
import com.example.wbdvsp21recipeplannerserverjava.repositories.RecipeIngredientRepository;
import com.example.wbdvsp21recipeplannerserverjava.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository repository;

    RecipeIngredientService ingredientService;

    public Recipe createRecipe(Recipe recipe){
        for(RecipeIngredient r: recipe.getExtendedIngredients()){
            ingredientService.createRecipeIngredient(recipe.getId(),r);
        }
        return repository.save(recipe);
    }

    public List<Recipe> findAllRecipes(){
        return (List<Recipe>) repository.findAll();
    }

    public void deleteRecipeById(String id) {
        Recipe recipe = findRecipeById(id);
        for(RecipeIngredient r: recipe.getExtendedIngredients()){
            ingredientService.deleteRecipeIngredientById(r.getId());
        }
        repository.deleteById(id);
    }

    public Integer updateRecipe(String recipeId, Recipe newRecipe){
        if (repository.existsById(recipeId)){
            newRecipe.setId(recipeId);
            for(RecipeIngredient r: newRecipe.getExtendedIngredients()){
                ingredientService.updateRecipeIngredient(r.getId(), r);
            }
            repository.save(newRecipe);
            return 1;
        }else {
            return -1;
        }
    }

    public Recipe findRecipeById(String id){
        try {
            return repository.findById(id).get();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public List<Recipe> findRecipeById(List<String> ids){
        ArrayList<Recipe> recipes = new ArrayList<>();
        for (String id: ids) {
            recipes.add(findRecipeById(id));
        }
        return recipes;
    }

    public List<Recipe> findRecipesForUser(Integer userId){
        return repository.findRecipeForUser(userId);
    }
}
