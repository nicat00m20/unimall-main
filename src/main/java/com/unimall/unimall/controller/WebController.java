package com.unimall.unimall.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unimall.unimall.entity.Product;
import com.unimall.unimall.service.ProductService;
@Controller
@RequestMapping
public class WebController {
    
	@Autowired
    private ProductService productService;

    @GetMapping("/home")
	public String home(Model model) {
		List<Product> productList= productService.getProducts();
		model.addAttribute("name", "Nijat");
		model.addAttribute("products",productList);
		return "home";
	}
}

