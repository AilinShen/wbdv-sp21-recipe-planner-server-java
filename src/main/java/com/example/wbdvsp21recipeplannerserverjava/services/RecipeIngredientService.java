package com.example.wbdvsp21recipeplannerserverjava.services;

import com.example.wbdvsp21recipeplannerserverjava.models.RecipeIngredient;
import com.example.wbdvsp21recipeplannerserverjava.repositories.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    @Autowired
    RecipeIngredientRepository repository;

    public List<RecipeIngredient> findAllRecipeIngredients(){
        return (List<RecipeIngredient>) repository.findAll();
    }

    public void deleteRecipeIngredientById(String id){
        repository.deleteById(Integer.parseInt(id));
    }
}
