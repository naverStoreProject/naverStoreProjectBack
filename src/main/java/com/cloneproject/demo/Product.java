package com.cloneproject.demo;

import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private Long category;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private int stockQuantity;
    private String thumbnailURL;
    private LocalDateTime createdAt;

    public Product(String name, int price, Long category, String description, int stockQuantity, String thumbnailURL, LocalDateTime createdAt) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.thumbnailURL = thumbnailURL;
        this.createdAt = createdAt;
    }

    public void decreaseQuantity(int quantity) {
        if (this.stockQuantity - quantity < 0) {
            throw new CustomException(ErrorCode.PRODUCT_OUT_OF_STOCK);
        }

        this.stockQuantity -= quantity;
    }
}
