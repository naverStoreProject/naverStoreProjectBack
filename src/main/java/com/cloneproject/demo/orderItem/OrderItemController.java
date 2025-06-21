package com.cloneproject.demo.orderItem;

import com.cloneproject.demo.response.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cloneproject.demo.response.SuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-item")
public class OrderItemController {
	
	private final OrderItemService orderItemService;
	
	//	주문 항목 리스트 조회
	@GetMapping("/order/{orderId}")
	public List<OrderItem> getByOrderId(@PathVariable Long orderId) {
		return orderItemService.getByOrderId(orderId);
	}
	
	//	키워드 검색
	@GetMapping("/search")
	public List<OrderItem> search(@RequestParam Long memberId, @RequestParam String keyword) {
		return orderItemService.searchByProductName(memberId, keyword);
	}
	
	//	상태 업데이트
	@PutMapping("/status")
	public void updateStatus(@RequestParam Long id, @RequestParam String status) {
		orderItemService.updateStatus(id, status);
	}
	
	//	주문항목 삭제
	@DeleteMapping("/api/order-items/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteItem(@PathVariable Long id) {
		orderItemService.deleteById(id);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_DELETE_SUCCESS));
	}
}