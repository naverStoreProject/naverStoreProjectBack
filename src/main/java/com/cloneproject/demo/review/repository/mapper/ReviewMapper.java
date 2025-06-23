package com.cloneproject.demo.review.repository.mapper;

import com.cloneproject.demo.review.Review;
import com.cloneproject.demo.review.dto.MyReview;
import com.cloneproject.demo.review.repository.ReviewRepository;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper extends ReviewRepository {

    List<MyReview> findMyReviews(Long memberId);

}
