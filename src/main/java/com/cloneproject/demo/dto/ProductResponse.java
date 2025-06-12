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

    public ProductResponse(Product product) {
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

    public ProductResponse(Tuple tuple) {
        this.name = tuple.get("name", String.class);
        this.brand = tuple.get("brand", String.class);
        this.originalPrice = tuple.get("original_price", Integer.class);
        this.discountRate = tuple.get("discount_rate", BigDecimal.class);
        this.currentPrice = tuple.get("current_price", BigDecimal.class).intValue();
        this.category = tuple.get("category", Long.class);
        this.stockQuantity = tuple.get("stock_quantity", Integer.class);
        this.description = tuple.get("description", String.class);
        this.image = tuple.get("image", String.class);

        if (tuple.get("average_rating") != null) this.averageRating = tuple.get("average_rating", BigDecimal.class);
        else this.averageRating = BigDecimal.valueOf(0.00);

        if (tuple.get("rating_count", Integer.class) != null) this.ratingCount = tuple.get("rating_count", Integer.class);
        else this.ratingCount = 0;
    }


}
