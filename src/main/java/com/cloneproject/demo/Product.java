package com.cloneproject.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private String category;
    private String description;
    private int stockQuantity;

    public Product(String name, int price, String category, String description, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.stockQuantity = stockQuantity;
    }

    public void decreaseQuantity(int quantity) {
        if (this.stockQuantity - quantity <= 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }

        this.stockQuantity -= quantity;
    }
}
