package com.cloneproject.demo.orderItem;

import com.cloneproject.demo.member.MemberRepository;
import com.cloneproject.demo.orderItem.repository.OrderItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //생성자 자동 생성
public class OrderItemService {
	
	//	필드
	private final OrderItemRepository orderItemRepository;
	private final MemberRepository memberRepository;
	
	//	주문 그룹 ID 기준으로 모든 주문 상품 조회
	public List<OrderItem> getByOrderId(Long orderId) {
		return orderItemRepository.findByOrderId(orderId);
	}
	
	//	상품명 중 한글자라도 있는 것 반환
	public List<OrderItem> searchByProductName(Long memberId, String keyword) {
		return orderItemRepository.searchByProductName(memberId, keyword);
	}
	
	//	상태 변경 처리
	public void updateStatus(Long id, String status) {
		orderItemRepository.updateStatus(id, status);

//		if ("구매확정".equals(status)) {
//			// 구매확정 시 포인트 적립
//			OrderItem item = orderItemRepository.findById(id);
//			memberRepository.updatePoint(item.getMemberId(), item.getPrice() / 100);
//		} else if ("환불완료".equals(status)) {
//			// 환불 시 포인트 회수
//			OrderItem item = orderItemRepository.findById(id);
//			memberRepository.updatePoint(item.getMemberId(), -(item.getPrice() / 100));
//		}
	}
	
	//	상품 삭제
	public void deleteById(Long id) {
		orderItemRepository.deleteById(id);
	}
	
	//	자동 구매 확정 처리
	public void autoUpdateConfirmed() {
		orderItemRepository.autoUpdateConfirmed();
	}
}