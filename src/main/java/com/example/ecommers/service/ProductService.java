package com.example.ecommers.service;

import com.example.ecommers.entity.Product;
import com.example.ecommers.repository.ProductRepository;
import com.example.ecommers.spec.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<String, Object> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("products", products.getContent());
        response.put("totalProducts", products.getTotalElements());
        return response;
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product is not found with id : " + id
                        )
                );
    }

    public List<Product> searchProduct(String category, Double minPrice, Double maxPrice, String keyword) {
        Specification<Product> spec = Specification
                .where(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.priceBetween(minPrice, maxPrice))
                .and(ProductSpecification.hasNameOrDescriptionLike(keyword));
        return productRepository.findAll(spec);
    }

}
