package com.cloneproject.demo.product;

import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String thumbnailUrl;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private int mainCategory;
    private int subCategory;

    private int originalPrice;
    private int discountRate;

    private int stockQuantity;
    private int averageRating;
    private int ratingCount;

    public void decreaseQuantity(int quantity) {
        if (this.stockQuantity - quantity < 0) {
            throw new CustomException(ErrorCode.PRODUCT_OUT_OF_STOCK);
        }

        this.stockQuantity -= quantity;
    }
}