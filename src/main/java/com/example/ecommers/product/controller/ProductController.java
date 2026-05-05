package com.example.ecommers.product.controller;

import com.example.ecommers.product.entity.Product;
import com.example.ecommers.product.service.ProductService;
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

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(required = false) String category, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice, @RequestParam(required = false) String keyword,  @RequestParam(required = false) Double rating){
        return productService.searchProduct(category,minPrice,maxPrice,keyword, rating);
    }

}

