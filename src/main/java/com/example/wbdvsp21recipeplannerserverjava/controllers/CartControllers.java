package com.example.wbdvsp21recipeplannerserverjava.controllers;

import com.example.wbdvsp21recipeplannerserverjava.models.Cart;
import com.example.wbdvsp21recipeplannerserverjava.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CartControllers {

    @Autowired
    CartService cartService;

    @GetMapping("/api/cart/{uid}")
    public Cart getCartForUser(@PathVariable("uid") Integer userId){
        return cartService.findCartForUser(userId);
    }
}
