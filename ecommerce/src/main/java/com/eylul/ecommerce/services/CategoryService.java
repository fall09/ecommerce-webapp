package com.eylul.ecommerce.services;

import com.eylul.ecommerce.models.Cart;
import com.eylul.ecommerce.models.Category;
import com.eylul.ecommerce.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
       return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    public void deleteCategory(Long id) {
        Category deletedCategory = categoryRepository.findById(id).get();
        categoryRepository.delete(deletedCategory);
    }
    public void updateCategory(Category category) {
        Category oldCategory = categoryRepository.findById(category.getId()).orElse(null);

        if(!category.getName().isBlank()){
            oldCategory.setName(category.getName());
            categoryRepository.save(oldCategory);
        }
    }
}
