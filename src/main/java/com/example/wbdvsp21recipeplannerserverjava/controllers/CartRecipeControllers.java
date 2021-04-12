package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Cart;
import com.example.wbdvsp21recipeplannerserverjava.models.CartRecipe;
import com.example.wbdvsp21recipeplannerserverjava.services.CartRecipeService;
import com.example.wbdvsp21recipeplannerserverjava.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CartRecipeControllers {

    @Autowired
    CartRecipeService cartRecipeService;

    @Autowired
    CartService cartService;

    @GetMapping("/api/cart/{uid}/recipes")
    public List<CartRecipe> getRecipesForCart(@PathVariable("uid") Integer userId){
        Cart cart = cartService.findCartForUser(userId);
        return cartRecipeService.findRecipesForCart(cart.getId());
    }

    @PostMapping("/api/cart/{uid}/recipes/{rid}")
    public CartRecipe createRecipe(@PathVariable("uid") Integer userId,
                                   @RequestBody CartRecipe recipe){
        Cart cart = cartService.findCartForUser(userId);
        recipe.setCartId(cart.getId());
        recipe.setCartRecipeUniqueId();
        return cartRecipeService.createRecipeForCart(recipe);
    }

    @PutMapping("/api/cart/{uid/recipes/{rid}")
    public Integer updateRecipe(@PathVariable("uid") Integer userId,
                                @PathVariable("rid") String cartRecipeId,
                                @RequestBody CartRecipe recipe){
        CartRecipe original = cartRecipeService.findCartRecipeById(cartRecipeId);
        original.setCartId(recipe.getCartId());
        original.setRecipeId(recipe.getRecipeId());
        return cartRecipeService.updateCartRecipe(cartRecipeId, original);
    }

    @DeleteMapping("/api/cart/{uid/recipes/{rid}")
    public Integer deleteRecipe(@PathVariable("uid") Integer userId,
                                @PathVariable("rid") String cartRecipeId){
        return cartRecipeService.deleteCartRecipe(cartRecipeId);
    }
}
