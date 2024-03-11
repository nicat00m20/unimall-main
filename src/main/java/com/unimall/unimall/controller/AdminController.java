package com.unimall.unimall.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.unimall.unimall.model.CategoryInputModel;
import com.unimall.unimall.model.ProductInputModel;
import com.unimall.unimall.service.CategoryService;
import com.unimall.unimall.service.ProductService;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping
public class AdminController {
    
	@Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    public static String UPLOAD_DIRECTORY = "/Users/Nijat/Downloads/unimall-main/src/main/resources/static/images";

    @GetMapping("/adminpanel/add-product")
	public String addProduct(Model model) {
		return "add_product";
	}

    @PostMapping("/adminpanel/add-product")
	public RedirectView createProduct(@RequestParam String product_name,String product_description,double product_price,Long categories,@RequestParam MultipartFile product_image, Model model) {
        UUID uuid = UUID.randomUUID();
        String file_name = uuid.toString().concat(getFileExtension(product_image.getOriginalFilename()));
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file_name);
        try {
            Files.write(fileNameAndPath, product_image.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ProductInputModel productInputModel = new ProductInputModel(product_name, product_description, product_price , categories,"images/"+file_name );
        productService.addProduct(productInputModel);
        return new RedirectView("http://localhost:8080/home");
	}
    
    @GetMapping("/adminpanel/add-category")
    public String addCategory(Model model) {
        
        return "add_category";
    }
    
    @PostMapping("/adminpanel/add-category")
    public RedirectView createCategory(@RequestParam String category_name, Long category_parentId) {
        
        CategoryInputModel categoryInputModel = new CategoryInputModel(category_name, category_parentId);
        categoryService.add(categoryInputModel);
        return new RedirectView("http://localhost:8080/home");
    }
    
    
    
    
    private String getFileExtension(String name) {
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; 
        }
        return name.substring(lastIndexOf);
    }
}

