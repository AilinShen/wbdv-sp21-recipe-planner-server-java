package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.UserFavorites;
import com.example.wbdvsp21recipeplannerserverjava.services.UserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FavoriteController {
    @Autowired
    UserFavoriteService service;

    @GetMapping("/api/favorites")
    public List<UserFavorites> findAllFavorites() {
        return service.findAllFavorites();
    }

    @PostMapping("/api/users/{uid}/recipe/{rid}/favorite")
    public UserFavorites createFavorite(
            @PathVariable("rid") String recipeId,
            @PathVariable("uid") Long userId,
            @RequestBody UserFavorites fav
    ) {
        fav.setRecipeId(recipeId);
        fav.setUserId(userId);
        return service.createFavorites(fav);
    }

    @GetMapping("/api/users/{uid}/favorites")
    public List<UserFavorites> findFavoritesForUser(
            @PathVariable("uid") Long userId
    ) {
        return service.findFavoritesForUser(userId);
    }

    @GetMapping("/api/users/{uid}/recipe/{rid}/favorite")
    public UserFavorites findFavorites(
            @PathVariable("uid") Long userId,
            @PathVariable("rid") String recipeId
    ) {
        return service.findFavorites(userId, recipeId);
    }

    @DeleteMapping("/api/favorites/{fId}")
    public Integer deleteFavorites(@PathVariable("fId") Long Id) {
        return service.deleteFavorites(Id);
    }

    @DeleteMapping("/api/users/{uid}/recipe/{rid}/favorite")
    public UserFavorites deleteRecipeFavoriteForUser(
            @PathVariable("uid") Long userId,
            @PathVariable("rid") String recipeId
    ){
        return service.deleteRecipeFavoriteForUser(userId, recipeId);
    }
}
