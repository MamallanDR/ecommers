package com.example.ecommers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(value = 1)
    @Max(value = 5)
    private int rating;

    private String comment;
}
