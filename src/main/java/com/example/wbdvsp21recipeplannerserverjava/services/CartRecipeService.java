package com.example.wbdvsp21recipeplannerserverjava.services;
import com.example.wbdvsp21recipeplannerserverjava.models.CartRecipe;
import com.example.wbdvsp21recipeplannerserverjava.repositories.CartRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartRecipeService {
    @Autowired
    CartRecipeRepository repository;

    public CartRecipe createRecipeForCart(CartRecipe recipe){
        return repository.save(recipe);
    }

    public List<CartRecipe> findRecipesForCart(Integer cartId){
        return repository.findRecipesForCart(cartId);
    }

    public CartRecipe findCartRecipeById(Integer cartRecipeId){
        return repository.findCartRecipeById(cartRecipeId);
    }


    public Integer deleteCartRecipe(String cartRecipeId){
        repository.deleteById(cartRecipeId);
        return 1;
    }

}
