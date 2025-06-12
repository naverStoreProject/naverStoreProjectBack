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
    private int price;
    private BigDecimal discountRate;
    private Long category;
    private String description;
    private int stockQuantity;
    private String thumbnailURL;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .brand(brand)
                .price(price)
                .discountRate(discountRate)
                .category(category)
                .description(description)
                .stockQuantity(stockQuantity)
                .thumbnailURL(thumbnailURL)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
