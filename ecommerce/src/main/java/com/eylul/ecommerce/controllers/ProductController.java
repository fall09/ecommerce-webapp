package com.eylul.ecommerce.controllers;

import com.eylul.ecommerce.models.Product;
import com.eylul.ecommerce.models.User;
import com.eylul.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/getById")
    public Product getProductById(@RequestParam("id") Long id) {
        return productService.findById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody Product product) {
        productService.update(product);
        return ResponseEntity.ok("Product updated successfully");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestParam("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }


}
