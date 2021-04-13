package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.CartRecipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CartRecipeRepository
extends CrudRepository<CartRecipe, String>{
    @Query(value="SELECT * FROM CartRecipe WHERE cartId=:cid", nativeQuery = true)
    public List<CartRecipe> findRecipesForCart(@Param("cid") String cartId);

    @Query(value="SELECT * FROM CartRecipe WHERE id=:cid", nativeQuery = true)
    public CartRecipe findCartRecipeById(@Param("cid") String cartRecipeId);
}
