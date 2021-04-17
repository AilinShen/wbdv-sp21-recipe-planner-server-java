package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, String> {

    @Query(value = "SELECT * FROM recipes WHERE user_id=:id", nativeQuery = true)
    public List<Recipe> findRecipeForUser(Integer id);

}
