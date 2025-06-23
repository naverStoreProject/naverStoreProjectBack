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
    private String thumbnailUrl;
    private String description;

    private int originalPrice;
    private int discountRate;
    private int currentPrice;

    private int mainCategory;
    private int subCategory;

    private int stockQuantity;
    private int averageRating;
    private int ratingCount;


    
//    public Product toEntity() {
//        return new Product(name, price, discountRate, category, description, stockQuantity, thumbnailURL, LocalDateTime.now());
//    }

    private ProductResponse(Product product) {
        this.name = product.getName();
        this.brand = product.getBrand();
        this.thumbnailUrl = product.getThumbnailUrl();
        this.description = product.getDescription();
        this.originalPrice = product.getOriginalPrice();
        this.discountRate = product.getDiscountRate();
        this.currentPrice = BigDecimal.valueOf(originalPrice)
                .multiply(BigDecimal.valueOf(100 - discountRate))
                .divide(BigDecimal.valueOf(100), 0, RoundingMode.HALF_UP)
                .intValue();
        this.mainCategory = product.getMainCategory();
        this.subCategory = product.getSubCategory();
        this.stockQuantity = product.getStockQuantity();
        this.averageRating = product.getAverageRating();
        this.ratingCount = product.getRatingCount();
    }

    public static ProductResponse of(Product product) {

        return ProductResponse.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .originalPrice(product.getOriginalPrice())
                .discountRate(product.getDiscountRate())
                .currentPrice(BigDecimal.valueOf(product.getOriginalPrice())
                        .multiply(BigDecimal.valueOf(10000 - product.getDiscountRate()))
                        .divide(BigDecimal.valueOf(10000), 0, RoundingMode.HALF_UP)
                        .intValue())
                .mainCategory(product.getMainCategory())
                .subCategory(product.getSubCategory())
                .description(product.getDescription())
                .stockQuantity(product.getStockQuantity())
                .thumbnailUrl(product.getThumbnailUrl())
                .build();
    }




//    public static ProductResponse of(Product product) {
//        return product == null ? null : new ProductResponse(product);
//    }


}
