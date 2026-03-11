package com.eylul.ecommerce.controllers;

import com.eylul.ecommerce.models.Order;
import com.eylul.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/getById")
    public Order getOrderById(@RequestParam("id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/getByUserId")
    public List<Order> getOrdersByUserId(@RequestParam("id") Long userId) {
        return orderService.findByUserId(userId);
    }

    @PostMapping("/checkout")
    public Order checkout(@RequestParam("id")  Long cartId) {
        return orderService.createOrderFromCart(cartId);
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam("id") Long id) {
        orderService.delete(id);
    }
}