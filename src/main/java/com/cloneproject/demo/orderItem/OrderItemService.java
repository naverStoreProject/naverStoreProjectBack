package com.cloneproject.demo.orderItem;

import com.cloneproject.demo.orderItem.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
	
	private final OrderItemRepository orderItemRepository;
	
	public List<OrderItem> getByOrderId(Long orderId) {
		return orderItemRepository.findByOrderId(orderId);
	}
	
	public List<OrderItem> searchByProductName(Long memberId, String keyword) {
		return orderItemRepository.searchByProductName(memberId, keyword);
	}
	
	public void deleteById(Long id) {
		orderItemRepository.deleteById(id);
	}
	
	public void updateStatus(Long id, String status) {
		orderItemRepository.updateStatus(id, status);
	}
}