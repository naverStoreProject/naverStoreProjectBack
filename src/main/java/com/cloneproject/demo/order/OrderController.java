package com.cloneproject.demo.order;

import com.cloneproject.demo.dto.OrderResponse;
import com.cloneproject.demo.response.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cloneproject.demo.response.SuccessCode;

@RestController
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	//	회원 ID로 주문 내역 전체 조회(1년 이내)
	@GetMapping
	public ResponseEntity<ApiResponse<List<OrderResponse>>> getOrders(@RequestParam Long memberId) {
		List<OrderResponse> orders = orderService.getOrdersByMemberId(memberId);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_FETCH_SUCCESS, orders));
	}
	
	//	상품명 키워드 검색
	@GetMapping("/search")
	public ResponseEntity<ApiResponse<List<OrderResponse>>> searchOrders(@RequestParam Long memberId,
			@RequestParam String keyword) {
		List<OrderResponse> result = orderService.searchOrdersByProductName(memberId, keyword);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_FETCH_SUCCESS, result));
	}
	
}
