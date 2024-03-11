package com.unimall.unimall.controller;

import org.springframework.web.bind.annotation.RestController;

import com.unimall.unimall.entity.Category;
import com.unimall.unimall.model.CategoryInputModel;
import com.unimall.unimall.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/category")
@Tag(name = "Category", description = "the Category api") 
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @Operation(summary = "get all Category", description = "there you can get all category", tags = {"Category"})
    @GetMapping
    public List<Category> getAll() {
        List<Category> categoryList= categoryService.getAll();
    return categoryList;
    }
    
    @PostMapping
    @Operation(summary = "add Category", description = "there you can add category", tags = {"Category"})
    public Category addCategory(@RequestBody CategoryInputModel categoryInputModel) {
        return categoryService.add(categoryInputModel);
    }
    @Operation(summary = "update Category", description = "there you can update category", tags = {"Category"})
    @PutMapping("/{id}")
    public Object updateById(@PathVariable Long id, @RequestBody String newName) {
       return categoryService.updateById(id, newName);
        
     
    }
    @Operation(summary = "delete Category", description = "there you can delete category", tags = {"Category"})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return categoryService.deleteById(id);

    }
    @Operation(summary = "deactivate Category", description = "there you can deactivate category", tags = {"Category"})   
    @PutMapping("deactivate/{id}")
       public Object deactivateById(@PathVariable Long id) {
        
        return categoryService.deactivateById(id);
           
          
       }
       @Operation(summary = "activate Category", description = "there you can activate category", tags = {"Category"}) 
       @PutMapping("activate/{id}")
        public Object activateById(@PathVariable Long id) {
        
            return categoryService.activateById(id);          
        }
    
}
