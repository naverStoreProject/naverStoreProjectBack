package com.cloneproject.demo.orderItem.repository;

import com.cloneproject.demo.orderItem.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderItemRepository {
	
	List<OrderItem> findByOrderId(Long orderId);
	
	void insert(OrderItem item);
	
	void updateStatus(Long id, String status);
}