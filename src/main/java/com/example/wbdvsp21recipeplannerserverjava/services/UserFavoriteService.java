package com.example.wbdvsp21recipeplannerserverjava.services;

import com.example.wbdvsp21recipeplannerserverjava.models.UserFavorites;
import com.example.wbdvsp21recipeplannerserverjava.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavoriteService {
    @Autowired
    FavoriteRepository repository;

    public List<UserFavorites> findAllFavorites(){
        return repository.findAllFavorites();
    }
    public UserFavorites createFavorites(UserFavorites fav) {
        return repository.save(fav);
    }
    public List<UserFavorites> findFavoritesForUser(Long userId){
        return repository.findFavoritesForUser(userId);
    }
    public Integer deleteFavorites(Long Id) {
        repository.deleteFavorites(Id);
        return 1;
    }
}
