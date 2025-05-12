package com.cloneproject.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class ReviewComment {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private Long reviewId;
    private Long userId;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean pinned;

    public ReviewComment(Long reviewId, Long userId, String content, LocalDateTime createdAt, LocalDateTime updatedAt, boolean pinned) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pinned = pinned;
    }
}
