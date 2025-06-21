package com.cloneproject.demo.orderItem;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-item")
@RequiredArgsConstructor
public class OrderItemController {
	
	private final OrderItemService orderItemService;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
		orderItemService.deleteOrderItem(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/confirm/{id}")
	public ResponseEntity<Void> confirmPurchase(@PathVariable Long id) {
		orderItemService.confirmPurchase(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/refund/{id}")
	public ResponseEntity<Void> refund(@PathVariable Long id) {
		orderItemService.refundOrderItem(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/member/{memberId}")
	public ResponseEntity<List<OrderItemDTO>> getOrderItemsByMember(@PathVariable Long memberId) {
		List<OrderItemDTO> items = orderItemService.getOrderItemsByMember(memberId);
		return ResponseEntity.ok(items);
	}
}