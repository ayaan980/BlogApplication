package com.example.blog.services;

import com.example.blog.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public CategoryDTO createCategory(CategoryDTO categoryDTO);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO,String categoryId);
    public void deleteCategory(String categoryId);
    public CategoryDTO getCategory(String categoryId);
    public List<CategoryDTO> getAllCategory();
}
