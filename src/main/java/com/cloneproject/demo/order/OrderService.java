package com.cloneproject.demo.order;

import com.cloneproject.demo.dto.OrderResponse;
import com.cloneproject.demo.member.Member;
import com.cloneproject.demo.member.MemberRepository;
import com.cloneproject.demo.product.ProductRepository;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;
	
	public List<OrderResponse> getOrdersByMemberId(Long memberId) {
//		회원 존재 여부 확인
		Member member = memberRepository.findById(memberId)
				                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

//		해당 회원의 주문 목록 조회
		List<Order> orders = orderRepository.findByMember(member);

//		주문 목록 매핑
		return orders.stream().map(order -> OrderResponse.builder()
				                                    .id(order.getId())
				                                    .status(order.getStatus().name())
				                                    .productName(order.getProductName())
				                                    .productImage(order.getProductImage())
				                                    .orderDate(order.getOrderDate())
				                                    .statusChangedDate(order.getStatusChangedDate())
				                                    .price(order.getPrice())
				                                    .company(order.getCompany())
				                                    .productLink(order.getProductLink())
				                                    .build()
		).collect(Collectors.toList());
	}
}
