package com.cloneproject.demo.review.repository;

import com.cloneproject.demo.review.Review;
import com.cloneproject.demo.review.dto.MyReview;

import java.util.List;

public interface ReviewRepository {

    List<MyReview> findMyReviews(Long memberId);

}
