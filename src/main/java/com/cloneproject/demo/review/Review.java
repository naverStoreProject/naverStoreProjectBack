package com.cloneproject.demo.review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
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

    public Review(Long productId, Long userId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, boolean deleted, boolean blinded, int likes, int dislikes, boolean verified) {
        this.productId = productId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
        this.blinded = blinded;
        this.likes = likes;
        this.dislikes = dislikes;
        this.verified = verified;
    }
}
