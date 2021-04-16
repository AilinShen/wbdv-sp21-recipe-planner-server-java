package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository
extends CrudRepository<Cart, Integer>{

    @Query(value="SELECT * FROM carts WHERE user_id=:uid", nativeQuery = true)
    List<Cart> findCartForUser(@Param("uid") Integer userId);

}
