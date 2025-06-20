package com.cloneproject.demo.dto;

import com.cloneproject.demo.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class ProductAddRequest {
    private String name;
    private String brand;
    private String thumbnailUrl;
    private String description;
    private int mainCategory;
    private int subCategory;
    private int originalPrice;
    private int discountRate;
    private int stockQuantity;
    private int averageRating;
    private int ratingCount;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .brand(brand)
                .thumbnailUrl(thumbnailUrl)
                .description(description)
                .mainCategory(mainCategory)
                .subCategory(subCategory)
                .originalPrice(originalPrice)
                .discountRate(discountRate)
                .stockQuantity(stockQuantity)
                .averageRating(averageRating)
                .ratingCount(ratingCount)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
