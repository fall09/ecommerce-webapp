package com.eylul.ecommerce.controllers;

import com.eylul.ecommerce.models.Cart;
import com.eylul.ecommerce.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/getAll")
    public List<Cart> getAllCarts() {
        return cartService.findAll();
    }

    @GetMapping("/getById")
    public Cart getCartById(@RequestParam("id") Long id) {
        Cart cart = cartService.findById(id);
        if (cart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
        }
        return cart;
    }

    @GetMapping("/getByUser/{userId}")
    public Cart getCartByUserId(@PathVariable Long userId) {
        return cartService.findByUserId(userId);
    }

    @PostMapping("/create")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @DeleteMapping("/delete")
    public void deleteCart(@RequestParam("id") Long id) {
        cartService.delete(id);
    }
}