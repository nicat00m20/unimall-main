package com.unimall.unimall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimall.unimall.entity.Product;
import com.unimall.unimall.model.ProductInputModel;
import com.unimall.unimall.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "the Product api") 
public class ProductController {
    @Autowired 
    ProductService productService;

    @Operation(summary = "get all Products", description = "there you can get all products", tags = {"Product"})
    @GetMapping
    public List<Product> getProducts(){
        List<Product> productsList = productService.getProducts();
        return productsList;
    }
    @Operation(summary = "Add  Product", description = "there you can add product", tags = {"Product"})
    @PostMapping
    public Object addProduct(@RequestBody ProductInputModel productInputModel){
       productService.addProduct(productInputModel);
       return "Product was successfully added!";
    }
    @Operation(summary = "Activate  Product", description = "there you can activate product", tags = {"Product"})
    @PutMapping("activate/{id}")
    public Object activateProduct(@PathVariable Long id){
        return productService.activateProduct(id);
    }
    
    @Operation(summary = "Deactivate  Product", description = "there you can deactivate product", tags = {"Product"})
    @PutMapping("deactivate/{id}")
    public Object deactivateProduct(@PathVariable Long id){
        return productService.deactivateProduct(id);
    }
   
    @Operation(summary = "Delete  Product", description = "there you can delete product", tags = {"Product"})
    @DeleteMapping("/{id}")
    public Object deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
    
    @Operation(summary = "Update  Product", description = "there you can update product", tags = {"Product"})
    @PutMapping("/{id}")
    public Object updateProduct(@PathVariable Long id, @RequestBody String newName){
        return productService.updateProduct(newName, id);
    }

}
