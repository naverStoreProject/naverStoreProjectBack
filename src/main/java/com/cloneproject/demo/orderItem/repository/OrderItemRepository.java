package com.cloneproject.demo.orderItem.repository;

import com.cloneproject.demo.orderItem.OrderItem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface OrderItemRepository {
	
	//	단일 주문 조회
//	OrderItem findById(@Param("id") Long id);
	
	//	주문 그룹 조회
	List<OrderItem> findByOrderId(@Param("orderId") Long orderId);
	
	//	키워드 기반 검색
	List<OrderItem> searchByProductName(@Param("memberId") Long memberId,
			@Param("keyword") String keyword);
	
	//	주문항목 삽입
	void insert(OrderItem item);
	
	//	주문항목 삭제
	void deleteById(@Param("id") Long id);
	
	//	주문항목 상태변경
	void updateStatus(@Param("id") Long id, @Param("status") String status);
	
	//	상태변경 시각 업데이트
	void updateStatusChangedDate(@Param("id") Long id);
	
	//	주문상태 자동 업데이트
	void autoUpdateConfirmed();
}