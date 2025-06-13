package com.cloneproject.demo.dto;

import com.cloneproject.demo.product.Product;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Tuple;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductResponse {
    private String name;
    private String brand;
    private int originalPrice;
    private BigDecimal discountRate;
    private int currentPrice;
    private Long category;
    private String description;
    private int stockQuantity;
    private String image;

    @Column(precision = 3, scale = 2)
    private BigDecimal averageRating;

    private int ratingCount;

    
//    public Product toEntity() {
//        return new Product(name, price, discountRate, category, description, stockQuantity, thumbnailURL, LocalDateTime.now());
//    }

    private ProductResponse(Product product) {
        this.name = product.getName();
        this.brand = product.getBrand();
        this.originalPrice = product.getPrice();
        this.discountRate = product.getDiscountRate();
        this.currentPrice = BigDecimal.valueOf(originalPrice)
                .multiply(BigDecimal.ONE.subtract(discountRate))
                .setScale(0, RoundingMode.HALF_UP)
                .intValue();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.stockQuantity = product.getStockQuantity();
        this.image = product.getThumbnailURL();
    }

    public static ProductResponse of(Product product) {
        return product == null ? null : new ProductResponse(product);
    }


}
