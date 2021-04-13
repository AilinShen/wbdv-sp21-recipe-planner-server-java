package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer userId;

    public Cart(){}

    public Cart(Integer userId) {
        //setCartUniqueId();
        this.userId = userId;
    }

    public Integer getId() {
        return cartId;
    }

    public void setId(Integer id) {
        this.cartId = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
