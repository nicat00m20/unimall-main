package com.unimall.unimall.service;

import java.util.List;


import com.unimall.unimall.entity.Product;
import com.unimall.unimall.model.ProductInputModel;

public interface  ProductService {
     Object addProduct(ProductInputModel productInputModel);
     Object deactivateProduct(Long id);
     List<Product> getProducts();
     Object activateProduct(Long id);
     Object deleteProduct(Long id);
     Object updateProduct(String newName, Long id);
    }
