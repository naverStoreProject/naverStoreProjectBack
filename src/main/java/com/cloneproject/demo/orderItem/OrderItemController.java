package com.cloneproject.demo.orderItem;

import com.cloneproject.demo.response.ApiResponse;
import com.cloneproject.demo.response.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-item")
public class OrderItemController {
	
	private final OrderItemService orderItemService;
	
	@GetMapping("/order/{orderId}")
	public List<OrderItem> getByOrderId(@PathVariable Long orderId) {
		return orderItemService.getByOrderId(orderId);
	}
	
	@GetMapping("/search")
	public List<OrderItem> search(@RequestParam Long memberId, @RequestParam String keyword) {
		return orderItemService.searchByProductName(memberId, keyword);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteItem(@PathVariable Long id) {
		orderItemService.deleteById(id);
		return ResponseEntity.ok(ApiResponse.success(SuccessCode.ORDER_DELETE_SUCCESS));
	}
}
