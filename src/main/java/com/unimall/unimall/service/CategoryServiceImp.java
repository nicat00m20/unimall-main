package com.unimall.unimall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimall.unimall.entity.Category;
import com.unimall.unimall.model.CategoryInputModel;
import com.unimall.unimall.repository.CategoryRepository;
@Service
public class CategoryServiceImp implements CategoryService{
   
    @Autowired
    private CategoryRepository categoryRepository;
   

    @Override
    public List<Category> getAll() {
        List<Category> categoryList= categoryRepository.getAll();
        return  categoryList;
    }

    @Override
    public Category add(CategoryInputModel categoryInputModel) {
        Category category = new Category();
        category.setName(categoryInputModel.categoryName());
        category.setParentId(categoryInputModel.parentId());
        category.setStatus(1);
      // categoryRepository.findById((long) 1);
       //categoryRepository.delete(category);
        return categoryRepository.save(category);
        
    }
    public String deleteById(Long id){
        
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Category was successfully deleted!"; 
        }else{
            return "Id not found!";
        }
       
    }

  

   

    public Object updateById(Long id, String newName){
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(newName);
            return categoryRepository.save(category);
        } else {
            return "id not found";
        }
    }

    public Object deactivateById(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setStatus(0);
            return categoryRepository.save(category);
        } else {
            return "id not found";
        }

    }
    public Object activateById(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setStatus(1);
            return categoryRepository.save(category);
        } else {
            return "id not found";
        }

    }



}
