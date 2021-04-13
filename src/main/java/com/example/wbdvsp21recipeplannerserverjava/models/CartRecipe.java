package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="cart_recipes")
public class CartRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String cartId;
    private String recipeId;

    public CartRecipe(){
        setCartRecipeUniqueId();
    }

    public CartRecipe(String cartId, String recipeId) {
        setCartRecipeUniqueId();
        this.cartId = cartId;
        this.recipeId = recipeId;
    }

    public void setCartRecipeUniqueId(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.setId("cart_rcp_"+ uuid);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }
}
