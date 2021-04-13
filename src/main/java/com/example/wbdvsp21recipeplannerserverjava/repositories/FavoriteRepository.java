package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.UserFavorites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteRepository
        extends CrudRepository<UserFavorites, Long> {
    @Query(value="SELECT * FROM user_favorites", nativeQuery = true)
    public List<UserFavorites> findAllFavorites();

    @Query(value="SELECT * FROM user_favorites WHERE user_id=:uid", nativeQuery = true)
    public List<UserFavorites> findFavoritesForUser(@Param("uid") Long userId);

    @Query(value="DELETE * FROM user_favorites WHERE id=:id", nativeQuery = true)
    public UserFavorites deleteFavorites(@Param("id") Long Id);
}
