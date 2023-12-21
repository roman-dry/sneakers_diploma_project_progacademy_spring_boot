package com.example.reactsneakersfinalproject.services;

import com.example.reactsneakersfinalproject.models.Cart;
import com.example.reactsneakersfinalproject.repositories.CartRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    @Transactional
    public void deleteCartById(Integer id) {
        cartRepository.deleteById(id);
    }
    @Transactional
    public void deleteCartByParentId(Integer user_id, Integer parent_id) {
        cartRepository.deleteByParentId(user_id, parent_id);
    }
    @Transactional
    public void deleteCartByUserId(Integer user_id) {
        cartRepository.deleteCartByUserId(user_id);
    }
    @Transactional(readOnly = true)
    public List<Cart> getCartsByUserId(Integer user_id) {
        return cartRepository.getCartsByUserId(user_id);
    }
    @Transactional
    public void updateCartById(Cart cart) {
        Integer count = cart.getCount();
        Integer totalprice = cart.getTotalPrice();
        Integer parent_id = cart.getParent_id();
        Integer user_id = cart.getUser_id();

        cartRepository.updateCartById(count, totalprice, parent_id, user_id);
    }

}
