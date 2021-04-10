package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.UserFavorites;
import com.example.wbdvsp21recipeplannerserverjava.services.UserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/api/users/{uid}/favorites")
    public UserFavorites createFavorite(
            @PathVariable("rid") Long recipeId,
            @RequestBody UserFavorites fav
    ) {
        fav.setRecipeId(recipeId);
        return service.createFavorites(fav);
    }

    @GetMapping("/api/users/{uid}/favorites")
    public List<UserFavorites> findFavoritesForUser(
            @PathVariable("uid") Long userId
    ) {
        return service.findFavoritesForUser(userId);
    }

    @DeleteMapping("api/favorites/{fid}")
    public Integer deleteFavorites(@PathVariable("fid") Long id) {
        return service.deleteFavorites(id);
    }
}
