package com.cloneproject.demo.orderItem;

import com.cloneproject.demo.member.repository.MemberRepository;
import com.cloneproject.demo.orderItem.repository.OrderItemRepository;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
	
	private final OrderItemRepository orderItemRepository;
	private final MemberRepository memberRepository;
	
	public void deleteOrderItem(Long id) {
		orderItemRepository.deleteById(id);
	}
	
	public void confirmPurchase(Long id) {
		OrderItem item = orderItemRepository.findById(id)
				                 .orElseThrow(() -> new CustomException(ErrorCode.ORDER_NOT_FOUND));
		item.setStatus("구매 확정");
		item.setStatusChangedDate(LocalDateTime.now());
		
		// 1% 포인트 리워드 로직 (예시)
		memberRepository.updatePoint(item.getOrderId(), (int) (item.getPrice() * 0.01));
		
		orderItemRepository.updateStatus(item);
	}
	
	public void refundOrderItem(Long id) {
		OrderItem item = orderItemRepository.findById(id)
				                 .orElseThrow(() -> new CustomException(ErrorCode.ORDER_NOT_FOUND));
		item.setStatus("환불 완료");
		item.setStatusChangedDate(LocalDateTime.now());
		
		// 환불 처리 로직 (예시)
		memberRepository.refundAmount(item.getOrderId(), item.getPrice());
		
		orderItemRepository.updateStatus(item);
	}
	
	public List<OrderItemDTO> getOrderItemsByMember(Long memberId) {
		return orderItemRepository.findAllByMemberId(memberId);
	}
}