package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Cart;
import com.example.wbdvsp21recipeplannerserverjava.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CartControllers {

    @Autowired
    CartService cartService;

    @GetMapping("/api/cart/{uid}")
    public List<Cart> getRecipesForCart(@PathVariable("uid") Integer userId){
        return cartService.findCartForUser(userId);
    }

    @PostMapping("/api/cart/{uid}")
    public Cart createRecipe(@PathVariable("uid") Integer userId,
                             @RequestBody Cart recipe){
        recipe.setUserId(userId);
        return cartService.createCartItemForUser(recipe);
    }

    @DeleteMapping("/api/cart/{uid}/{rid}")
    public Integer deleteRecipe(@PathVariable("uid") Integer userId,
                                @PathVariable("rid") Integer cartId){
        return cartService.deleteCartItem(cartId);
    }
}
