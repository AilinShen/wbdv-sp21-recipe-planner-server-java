package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CartRepository
extends CrudRepository<Cart, String>{
    @Query(value="SELECT * FROM cart WHERE userId=:uid", nativeQuery = true)
    public Cart findCartForUser(@Param("uid") Integer userId);

    @Query(value="SELECT * FROM cart WHERE id=:cid", nativeQuery = true)
    public Cart findCartById(@Param("cid") String cartId);
}
