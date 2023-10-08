package com.example.reactsneakersfinalproject.controllers;

import com.example.reactsneakersfinalproject.models.Cart;
import com.example.reactsneakersfinalproject.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCartById(@PathVariable("id") int id) {
        cartService.deleteCartById(id);
    }

    @DeleteMapping("/carted")
    public void deleteCartByParentId(@RequestParam int user_id, @RequestParam int parent_id ) {
        cartService.deleteCartByParentId(user_id, parent_id);
    }

    @DeleteMapping("/cart")
    public void deleteCartByUserId(@RequestParam int user_id) {
        cartService.deleteCartByUserId(user_id);
    }

    @GetMapping("/cart")
    public List<Cart> getCartsByUserId(@RequestParam int user_id) {
        return cartService.getCartsByUserId(user_id);
    }
    @PutMapping ("/cart")
    public void updateCartById(@RequestBody Cart cart) {
        cartService.updateCartById(cart);
    }
}