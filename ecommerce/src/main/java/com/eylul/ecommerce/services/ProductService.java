package com.eylul.ecommerce.services;

import com.eylul.ecommerce.models.Product;
import com.eylul.ecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void update(Product newProduct) {

        Product existingProduct = productRepository.findById(newProduct.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setName(
                newProduct.getName() != null ? newProduct.getName() : existingProduct.getName()
        );

        existingProduct.setDescription(
                newProduct.getDescription() != null ? newProduct.getDescription() : existingProduct.getDescription()
        );

        existingProduct.setPrice(
                newProduct.getPrice() != 0 ? newProduct.getPrice() : existingProduct.getPrice()
        );

        existingProduct.setStock(
                newProduct.getStock() != null ? newProduct.getStock() : existingProduct.getStock()
        );
        existingProduct.setCategory(
                newProduct.getCategory() != null ? newProduct.getCategory() : existingProduct.getCategory()
        );
        existingProduct.setImgUrl(
                newProduct.getImgUrl() != null ? newProduct.getImgUrl() : existingProduct.getImgUrl()
        );
        productRepository.save(existingProduct);
    }

}
