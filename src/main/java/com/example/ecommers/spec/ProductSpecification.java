package com.example.ecommers.spec;

import com.example.ecommers.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasCatagory(String category) {
        return (root, query, callback) -> {
            if (category == null) {
                return null;
            } else {
                return callback.equal(root.get("category"), category);
            }

        };
    }

    public static Specification<Product> priceBetween(Double min, Double max) {

        return ((root, query, criteriaBuilder) -> {
            if (min == null && max == null) return null;

            if (min == null) return criteriaBuilder.lessThanOrEqualTo(root.get("price"), max);

            if (max == null) return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), min);

            return criteriaBuilder.between(root.get("price"), min, max);
        });

    }

    public static Specification<Product> asNameOrDescriptionLike(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isBlank()) {
                return null;
            }

            String pattern = "%" + keyword.toLowerCase() + "%";

            return criteriaBuilder
                    .or(criteriaBuilder.like(root.get("name"), pattern),
                            criteriaBuilder.like(root.get("description"), pattern)
                    );
        };
    }

}
