package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.RecipeIngredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {

    @Query(value="SELECT * FROM recipe_ingredients WHERE recipe_id=:rid", nativeQuery = true)
    public List<RecipeIngredient> findIngredientsForRecipe(@Param("rid") String recipeId);

}
