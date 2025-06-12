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
    private int price;
    @Column(precision = 3, scale = 2)
    private BigDecimal discountRate;
    private Long category;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private int stockQuantity;
    private String thumbnailURL;
    private LocalDateTime createdAt;


    public void decreaseQuantity(int quantity) {
        if (this.stockQuantity - quantity < 0) {
            throw new CustomException(ErrorCode.PRODUCT_OUT_OF_STOCK);
        }

        this.stockQuantity -= quantity;
    }
}
