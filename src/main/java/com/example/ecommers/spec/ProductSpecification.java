package com.example.ecommers.spec;

import com.example.ecommers.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasCatagory(String category){
        return (root, query, callback)->{
                if(category == null){
                    return null;
                }else {
                  return callback.equal(root.get("category"),category);
                }

        };
    }
}
