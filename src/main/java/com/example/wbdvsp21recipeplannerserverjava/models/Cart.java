package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Integer userId;

    public Cart(){
        setCartUniqueId();
    }

    public Cart(Integer userId) {
        setCartUniqueId();
        this.userId = userId;
    }

    public void setCartUniqueId(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.setId("cart_"+ uuid);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
