package com.example.filrouge.service;

import com.example.filrouge.model.Category;

import java.util.List;

public interface categoryService {
    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public List<Category> getCategories();

    public void deleteCategory(Long id);

    public Category getCategoryById(Long id);
}
