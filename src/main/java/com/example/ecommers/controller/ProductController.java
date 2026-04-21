package com.example.ecommers.controller;


import com.example.ecommers.entity.Product;
import com.example.ecommers.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Map<String , Object> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
       return  productService.getAllProducts(page , size);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


}
