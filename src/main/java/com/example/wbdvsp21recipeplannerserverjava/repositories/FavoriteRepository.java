package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.UserFavorites;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteRepository
        extends CrudRepository<UserFavorites, Long> {
    @Query(value = "SELECT * FROM user_favorites", nativeQuery = true)
    public List<UserFavorites> findAllFavorites();

    @Query(value = "SELECT * FROM user_favorites WHERE user_id=:uid", nativeQuery = true)
    public List<UserFavorites> findFavoritesForUser(@Param("uid") Long userId);

    @Query(value = "SELECT * FROM user_favorites WHERE user_id=:uid and recipe_id=:rid", nativeQuery = true)
    public UserFavorites findFavorites(@Param("uid") Long user_id, @Param("rid") Long recipe_id);
}
