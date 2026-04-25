package com.example.ecommers.spec;

import com.example.ecommers.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasCategory(String category) {
        return (root, query, criteriaBuilder) -> {
            if (category == null || category.isBlank()) {
                return null;
            }

            return criteriaBuilder.equal(
                    criteriaBuilder.lower(root.get("category")),
                    category.toLowerCase()
            );

        };
    }

    public static Specification<Product> priceBetween(Double min, Double max) {
        return (root, query, criteriaBuilder) -> {
            if (min == null && max == null) {
                return null;
            }
            if (min == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), max);
            }
            if (max == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), min);
            }
            return criteriaBuilder.between(root.get("price"), min, max);
        };
    }

    public static Specification<Product> hasNameOrDescriptionLike(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isBlank()) {
                return null;
            }

            String pattern = "%" + keyword.toLowerCase() + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("name")),
                            pattern
                    ),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("description")),
                            pattern
                    )
            );
        };
    }
}