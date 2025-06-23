package com.cloneproject.demo.review.dto;

import com.cloneproject.demo.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MyReview {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
    private boolean blinded;
    private int likes;
    private int dislikes;
    private boolean verified;
    private BigDecimal rating;
    private Product product;
}
