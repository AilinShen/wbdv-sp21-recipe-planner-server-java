package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.CartRecipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CartRecipeRepository
extends CrudRepository<CartRecipe, String>{

    @Query(value="SELECT * FROM cart_recipes WHERE cart_id=:cid", nativeQuery = true)
    public List<CartRecipe> findRecipesForCart(@Param("cid") Integer cartId);

    @Query(value="SELECT * FROM cart_recipes WHERE cart_recipe_id=:cid", nativeQuery = true)
    public CartRecipe findCartRecipeById(@Param("cid") Integer cartRecipeId);
}
