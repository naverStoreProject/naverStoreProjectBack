package com.cloneproject.demo.review;

import com.cloneproject.demo.auth.dto.LoginMember;
import com.cloneproject.demo.response.ApiResponse;
import com.cloneproject.demo.response.SuccessCode;
import com.cloneproject.demo.review.dto.MyReview;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/api/review/my")
    public ResponseEntity<ApiResponse<List<MyReview>>> getMyReviews(@AuthenticationPrincipal LoginMember loginMember) {
        Long memberId = loginMember.getId();
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.REVIEW_FETCH_SUCCESS, reviewService.getMyReviews(memberId)));
    }
}
