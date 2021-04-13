package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="cart_recipes")
public class CartRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartRecipeId;
    private Integer cartId;
    private String recipeId;

    public CartRecipe(){
        //setCartRecipeUniqueId();
    }

    public CartRecipe(Integer cartId, String recipeId) {
        //setCartRecipeUniqueId();
        this.cartId = cartId;
        this.recipeId = recipeId;
    }

    public Integer getId() {
        return cartRecipeId;
    }

    public void setId(Integer id) {
        this.cartRecipeId = id;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }
}
