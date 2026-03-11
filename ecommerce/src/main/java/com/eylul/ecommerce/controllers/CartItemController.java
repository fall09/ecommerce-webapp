package com.eylul.ecommerce.controllers;

import com.eylul.ecommerce.models.CartItem;
import com.eylul.ecommerce.services.CartItemService;
import com.eylul.ecommerce.dto.AddToCartRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart-item")
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/getByCartId")
    public List<CartItem> getCartItemsByCartId(@RequestParam("id") Long cartId) {
        return cartItemService.findByCartId(cartId);
    }

    @PostMapping("/addToCart")
    public CartItem addProductToCart(@RequestBody AddToCartRequest request) {

        return cartItemService.addProductToCart(
                request.getCartId(),
                request.getProductId(),
                request.getQuantity()
        );
    }
    @PutMapping("/updateQuantity")
    public CartItem updateCartItemQuantity(
            @RequestParam("id") Long id,
            @RequestParam("quantity") Integer quantity) {

        return cartItemService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/delete")
    public void deleteCartItem(@RequestParam("id") Long id) {
        cartItemService.removeCartItem(id);
    }
}