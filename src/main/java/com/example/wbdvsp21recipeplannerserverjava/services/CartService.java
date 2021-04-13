package com.example.wbdvsp21recipeplannerserverjava.services;
import com.example.wbdvsp21recipeplannerserverjava.models.Cart;
import com.example.wbdvsp21recipeplannerserverjava.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public Cart createCartForUser(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart findCartForUser(Integer userId){
        Cart cart = cartRepository.findCartForUser(userId);
        if(cart == null){
            cart = createCartForUser(new Cart(userId));
        }
        return cart;
    }

    public Cart findCartById(String cartId){
        return cartRepository.findCartById(cartId);
    }

    public Integer updateCart(String cartId, Cart cart){
        Cart original = findCartById(cartId);
        original.setUserId(cart.getUserId());
        cartRepository.save(original);
        return 1;
    }

    public Integer deleteCart(String cartId){
        cartRepository.deleteById(cartId);
        return 1;
    }

}
