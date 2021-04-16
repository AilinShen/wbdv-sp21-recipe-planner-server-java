package com.example.wbdvsp21recipeplannerserverjava.services;
import com.example.wbdvsp21recipeplannerserverjava.models.Cart;
import com.example.wbdvsp21recipeplannerserverjava.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public Cart createCartItemForUser(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> findCartForUser(Integer userId){
        return cartRepository.findCartForUser(userId);
    }

    public Integer deleteCartItem(Integer cartId){
        cartRepository.deleteById(cartId);
        return 1;
    }

}
