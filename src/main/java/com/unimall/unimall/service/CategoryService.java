package com.unimall.unimall.service;

import java.util.List;


import com.unimall.unimall.entity.Category;
import com.unimall.unimall.model.CategoryInputModel;


public interface CategoryService {
    List<Category> getAll();
    Category add(CategoryInputModel categoryInputModel);
    String deleteById(Long id);
    Object updateById(Long id, String newName);
    Object deactivateById(Long id);
    Object activateById(Long id);

}
