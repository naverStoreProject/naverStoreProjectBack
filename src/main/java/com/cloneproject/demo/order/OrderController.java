//요청 수신
package com.cloneproject.demo.order;

import com.cloneproject.demo.auth.dto.LoginMember;
import com.cloneproject.demo.dto.OrderItemRequest;
import com.cloneproject.demo.dto.OrderItemResponse;
import com.cloneproject.demo.response.ApiResponse;
import com.cloneproject.demo.response.SuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	//주문등록
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/api/order")
	public ResponseEntity<ApiResponse<Void>> createOrder(
			@AuthenticationPrincipal LoginMember loginMember,
			@RequestBody @Valid OrderItemRequest orderItemRequest) {
		OrderItem orderItem = orderItemRequest.toEntity();
		orderService.insertOrderItem(loginMember.getId(), orderItem);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_CREATE_SUCCESS));
	}
	
	//주문목록조회
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/api/order/my")
	public ResponseEntity<ApiResponse<List<OrderItemResponse>>> getMyOrders(
			@AuthenticationPrincipal LoginMember loginMember) {
		List<OrderItemResponse> orders = orderService.findByMemberId(loginMember.getId());
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_FETCH_SUCCESS, orders));
	}
	
	//주문상세조회
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/api/order/{orderId}")
	public ResponseEntity<ApiResponse<OrderItemResponse>> getOrder(
			@PathVariable Long orderId,
			@AuthenticationPrincipal LoginMember loginMember) {
		OrderItemResponse order = orderService.findByMemberId(loginMember.getId(), orderId);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_FETCH_SUCCESS, order));
	}
	
	//주문상태변경
	@PreAuthorize("hasRole('USER')")
	@PatchMapping("/api/order/{orderId}/status")
	public ResponseEntity<ApiResponse<Void>> changeOrderStatus(
			@PathVariable Long orderId,
			@RequestParam String status,
			@AuthenticationPrincipal LoginMember loginMember) {
		orderService.setStatus(loginMember.getId(), orderId, status);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_UPDATE_SUCCESS));
	}
	
	//주문삭제
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/api/order/{orderId}")
	public ResponseEntity<ApiResponse<Void>> deleteOrder(
			@PathVariable Long orderId,
			@AuthenticationPrincipal LoginMember loginMember) {
		orderService.deleteOrderItem(loginMember.getId(), orderId);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_DELETE_SUCCESS));
	}
	
	//주문갯수
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/api/order/my/count")
	public ResponseEntity<ApiResponse<Integer>> countMyOrders(
			@AuthenticationPrincipal LoginMember loginMember) {
		int count = orderService.countOrderItem(loginMember.getId());
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_FETCH_SUCCESS, count));
	}
}
