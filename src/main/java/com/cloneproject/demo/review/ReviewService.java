package com.cloneproject.demo.review;

import com.cloneproject.demo.review.dto.MyReview;
import com.cloneproject.demo.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<MyReview> getMyReviews(Long memberId) {
        return reviewRepository.findMyReviews(memberId);
    }

}
