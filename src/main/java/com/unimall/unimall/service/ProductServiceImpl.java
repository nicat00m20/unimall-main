package com.unimall.unimall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimall.unimall.entity.Product;
import com.unimall.unimall.model.ProductInputModel;
import com.unimall.unimall.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    ProductRepository productRepository;

    @Override
    public  Object addProduct(ProductInputModel productInputModel){
        Product product = new Product(productInputModel);
        product.setName(productInputModel.productName());
        product.setDescription(productInputModel.description());
        product.setStatus(1);
        product.setDescription(productInputModel.description());
        product.setCategory(productInputModel.category());
        return productRepository.save(product);
    }
    @Override
    public List<Product> getProducts(){
        List<Product> productList = productRepository.getProducts();
        return productList;
    }
    public Object deactivateProduct(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            product.setStatus(0);
            return productRepository.save(product);
        }else{
            return "Product with id of "+id+" could not found";
        }
   
    }
    public Object activateProduct(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            product.setStatus(1);
            return productRepository.save(product);
        }else{
            return "Product with an id of "+id+" could not be found";
        }
   
    }
    public Object deleteProduct(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            productRepository.deleteById(id);
            return "Product with an id of "+id+" deleted successfully!";
        }else{
            return "Product with an id of "+id+" could not be found!";
        }
    }
    public Object updateProduct(String newName, Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            product.setName(newName);
        return productRepository.save(product);
        }else{
            return "Product with an id of "+id+" could not be found!";
        }
    }





}
