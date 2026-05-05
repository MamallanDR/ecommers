package com.example.ecommers.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name feild is required")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "price feild is required")
    @PositiveOrZero(message = "value must be 0 or above")
    private double price;

    @NotBlank(message = "description feild is required")
    private String description;

    private String category;

    private double rating = 0.0;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    @Column(nullable = false)
    @NotBlank(message = "seller feild is required")
    private String seller;

    @NotNull(message = "stock feild is required")
    @PositiveOrZero(message = "value must be 0 or above")
    private int stock;

    private int numOfReviews = 0;

}
