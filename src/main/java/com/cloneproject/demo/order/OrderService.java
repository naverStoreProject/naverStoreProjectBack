//비즈니스 로직
package com.cloneproject.demo.order;

import com.cloneproject.demo.dto.OrderItemResponse;
import com.cloneproject.demo.order.repository.mapper.OrderMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderMapper orderMapper;
	
	//주문 추가
	public int insertOrderItem(Long id, OrderItem orderItem) {
		// 주문 아이템에 memberId 설정
		orderItem.setOrderGroupId(id);
		orderItem.setOrderTime(LocalDateTime.now());
		orderItem.setStatus(OrderEnum.주문완료);
		orderItem.setStatusChangedTime(LocalDateTime.now());
//		memberId는 OrderGroup을 통해 조인
		return orderMapper.insertOrderItem(orderItem);
	}
	
	//	회원별 주문내역 조회
	public List<OrderItemResponse> findByMemberId(Long memberId) {
		List<OrderItem> items = orderMapper.findByMemberId(memberId);
		return items.stream()
				       .map(OrderItemResponse::from)
				       .collect(Collectors.toList());
	}
	
	// 주문 상세 조회
	public OrderItemResponse findByMemberId(Long memberId, Long orderId) {
		OrderItem item = orderMapper.findByMemberIdAndOrderId(memberId, orderId);
		return OrderItemResponse.from(item);
	}
	
	//	주문 상태 변경
	public void setStatus(Long memberId, Long orderId, String status) {
		OrderEnum orderEnum = OrderEnum.valueOf(status);
		orderMapper.setStatus(orderId, orderEnum, LocalDateTime.now());
	}
	
	//	배송완료 일주일 후 자동 업데이트
	public int updateStatusToConfirmed() {
		return orderMapper.updateStatusToConfirmed();
	}
	
	//	주문내역 카운트
	public int countOrderItem(Long memberId) {
		return orderMapper.countOrderItem(memberId);
	}
	
	//	주문내역 삭제
	public int deleteOrderItem(Long orderId, Long memberId) {
		return orderMapper.deleteOrderItem(orderId, memberId);
	}
}
