package com.cloneproject.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SuccessCode {
	// Member
	MEMBER_FETCH_SUCCESS(100, "회원 조회 성공"),
	MEMBER_CREATE_SUCCESS(101, "회원 가입 성공"),
	MEMBER_UPDATE_SUCCESS(102, "회원 정보 수정 성공"),
	
	// Product
	PRODUCT_FETCH_SUCCESS(200, "상품 조회 성공"),
	PRODUCT_SAVE_SUCCESS(201, "상품 저장 성공"),
	PRODUCT_ORDER_SUCCESS(202, "상품 주문 성공"),
	
	// Login
	LOGIN_SUCCESS(301, "로그인 성공"),
	
	// Review
	REVIEW_FETCH_SUCCESS(400, "리뷰 조회 성공"),
	
	// MainBanner
	MB_FETCH_SUCCESS(500, "메인 배너 가져오기 성공"),
	
	//    Order
	ORDER_CREATE_SUCCESS(600, "주문 생성 성공"),
	ORDER_FETCH_SUCCESS(601, "주문 조회 성공"),
	ORDER_UPDATE_SUCCESS(602, "주문 상태 변경 성공"),
	ORDER_DELETE_SUCCESS(603, "주문 삭제 성공");
	
	private final int code;
	private final String message;
}
