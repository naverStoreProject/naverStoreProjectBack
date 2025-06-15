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
	
	//	특정 회원의 전체 주문내역 조회
	@GetMapping("/api/order/id")
	public ResponseEntity<ApiResponse<List<OrderResponse>>> getOrdersByMemberId(
			@RequestParam Long memberId) {
		List<OrderResponse> orders = orderService.getOrdersByMemberId(memberId);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_FETCH_SUCCESS, orders));
	}
}
