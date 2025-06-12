package com.cloneproject.demo.review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Long userId;
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
    private boolean blinded;
    private int likes;
    private int dislikes;
    private boolean verified;
    @Column(precision = 2, scale = 1)
    private BigDecimal rating;


}
