package com.eylul.ecommerce.controllers;

import com.eylul.ecommerce.models.Category;
import com.eylul.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAllCategories() {
       return categoryService.getCategories();
    }

    @PostMapping("/add")
    public void saveCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @GetMapping("/getById")
    public Category getCategoryById(@RequestParam Long id) {
        return categoryService.getCategoryById(id);
    }
    @DeleteMapping("/delete")
    public void deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategory(id);
    }
    @PutMapping("/update")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }
}
