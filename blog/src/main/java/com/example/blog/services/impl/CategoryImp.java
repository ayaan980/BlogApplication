package com.example.blog.services.impl;

import com.example.blog.entity.Category;
import com.example.blog.entity.User;
import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.payloads.CategoryDTO;
import com.example.blog.payloads.UserDTO;
import com.example.blog.repositries.CategoryRepo;
import com.example.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryImp implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        String randomUserId = UUID.randomUUID().toString();
        categoryDTO.setCategoryId(randomUserId);
        Category category=this.dtoToCategory(categoryDTO);
        Category savedCategory= this.categoryRepo.save(category);
        return this.categoryToDTO(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, String categoryId) {
        Category category=this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException());
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDesc(categoryDTO.getCategoryDesc());


        Category updatedCategory = this.categoryRepo.save(category);
        CategoryDTO categoryDTO1=this.categoryToDTO(updatedCategory);
        return null;
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category=this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException());
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDTO getCategory(String categoryId) {
        Category category=this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException());
        return this.categoryToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList = this.categoryRepo.findAll();
        List<CategoryDTO> collect = categoryList.stream().map(user -> this.categoryToDTO(user)).collect(Collectors.toList());
        return collect;
    }
    private Category dtoToCategory(CategoryDTO categoryDTO) {
        Category category =this.modelMapper.map(categoryDTO,Category.class);

        return category;
    }

    public CategoryDTO categoryToDTO(Category category) {
        CategoryDTO categoryDTO=this.modelMapper.map(category,CategoryDTO.class);
        return categoryDTO;
    }
}
