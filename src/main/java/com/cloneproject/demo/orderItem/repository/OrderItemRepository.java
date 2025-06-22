package com.cloneproject.demo.orderItem.repository;

import com.cloneproject.demo.orderItem.OrderItem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderItemRepository {
	
	List<OrderItem> findByOrderId(Long orderId);
	
	List<OrderItem> searchByProductName(@Param("memberId") Long memberId,
			@Param("keyword") String keyword);
	
	void deleteById(Long id);
	
	void updateStatus(@Param("id") Long id, @Param("status") String status);
}