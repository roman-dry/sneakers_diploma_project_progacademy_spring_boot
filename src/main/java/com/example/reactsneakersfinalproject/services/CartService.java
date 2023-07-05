package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Cart;
import com.example.reactsneakersfinalproject.repositories.CartRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Data
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCartById(int id) {
        cartRepository.deleteById(id);
    }

    public void deleteCartByUserId(int user_id) {
        cartRepository.deleteCartByUserId(user_id);
    }

    public List<Cart> getCartsByUserId(int user_id) {
        return cartRepository.getCartsByUserId(user_id);
    }

    public void updateCartById(Cart cart) {
        int count = cart.getCount();
        int totalprice = cart.getTotalPrice();
        int parent_id = cart.getParent_id();
        int user_id = cart.getUser_id();

        cartRepository.updateCartById(count, totalprice, parent_id, user_id);
    }

}
