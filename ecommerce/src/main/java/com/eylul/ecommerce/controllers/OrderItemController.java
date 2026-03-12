package com.eylul.ecommerce.controllers;
import com.eylul.ecommerce.models.OrderItem;
import com.eylul.ecommerce.services.OrderItemService;
import lombok.*;
import java.util.List;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/getAll")
    public List<OrderItem> getAll() {
        return orderItemService.findAll();
    }

    @GetMapping("/order")
    public List<OrderItem> getByOrder(@RequestParam("id") Long orderId) {
        return orderItemService.findByOrderId(orderId);
    }

    @PostMapping
    public OrderItem add(@RequestBody OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Long id) {
        orderItemService.delete(id);
    }
}