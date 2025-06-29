package com.cloneproject.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    // Member
    MEMBER_NOT_FOUND(1001, "회원 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATE_EMAIL(1002, "이미 사용 중인 이메일입니다.", HttpStatus.CONFLICT),
    INVALID_PHONE_FORMAT(1003, "올바르지 않는 전화번호 형식입니다.", HttpStatus.BAD_REQUEST),

    // Product
    PRODUCT_NOT_FOUND(2001, "상품 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    PRODUCT_OUT_OF_STOCK(2002, "상품 재고가 부족합니다", HttpStatus.BAD_REQUEST),
    DUPLICATE_PRODUCT(2003, "이미 있는 상품입니다.", HttpStatus.CONFLICT),

    // Review
    REVIEW_NOT_FOUND(3001, "후기 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    // Login
    INVALID_TOKEN(4001, "유효하지 않은 토큰", HttpStatus.UNAUTHORIZED),
    INVALID_EMAIL(4002, "올바르지 않은 이메일", HttpStatus.UNAUTHORIZED),
    INVALID_PASSWORD(4003, "올바르지 않은 비밀번호", HttpStatus.UNAUTHORIZED),
    ACCESS_DENIED(4004, "권한이 없습니다.", HttpStatus.FORBIDDEN),

    // mainBanner
    MAINBANNER_NOT_FOUND(5001, "메인 배너를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);


    private final int code;
    private final String message;
    private final HttpStatus status;


}
