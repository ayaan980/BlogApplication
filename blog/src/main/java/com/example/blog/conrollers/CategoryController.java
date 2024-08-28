package com.example.blog.conrollers;

import com.example.blog.payloads.CategoryDTO;
import com.example.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO category = this.categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,@PathVariable String categoryId){
        CategoryDTO categoryDTO1 = this.categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(categoryDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId){
        this.categoryService.deleteCategory(categoryId);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> allCategory = this.categoryService.getAllCategory();
        return new ResponseEntity<>(allCategory,HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable String categoryId){
       CategoryDTO category = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
}
