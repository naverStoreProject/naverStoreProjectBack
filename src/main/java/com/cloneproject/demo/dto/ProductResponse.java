package com.cloneproject.demo.dto;

import com.cloneproject.demo.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class ProductResponse {
    private String name;
    private int price;
    private Long category;
    private String description;
    private int stockQuantity;
    private String thumbnailURL;

    
    public Product toEntity() {
        return new Product(name, price, category, description, stockQuantity, thumbnailURL, LocalDateTime.now());
    }

    public ProductResponse(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.stockQuantity = product.getStockQuantity();
        this.thumbnailURL = product.getThumbnailURL();
    }


}
