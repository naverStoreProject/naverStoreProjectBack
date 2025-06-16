package com.cloneproject.demo.order;

import com.cloneproject.demo.dto.OrderResponse;
import com.cloneproject.demo.member.Member;
import com.cloneproject.demo.member.MemberRepository;
import com.cloneproject.demo.product.ProductRepository;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;
	
	//	1년 이내 해당 ID 전체 주문내역 조회
	public List<OrderResponse> getOrdersByMemberId(Long memberId) {
		Member member = memberRepository.findById(memberId)
				                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
		LocalDateTime oneYearAgo = LocalDateTime.now().minusYears(1);
		
		return orderRepository.findByMemberOrderInAYearByOrderDateDesc(member, oneYearAgo)
				       .stream()
				       .flatMap(order -> order.getOrderItems().stream().map(item ->
						                                                            OrderResponse.builder()
								                                                            .id(order.getId()
										                                                                .toString())
								                                                            .status(
										                                                            item.getOrderStatus()
												                                                            .name())
								                                                            .productName(
										                                                            item.getProductName())
								                                                            .productImage(
										                                                            item.getProductImage())
								                                                            .orderDate(
										                                                            order.getOrderDate())
								                                                            .statusChangedDate(
										                                                            item.getStatusChanged())
								                                                            .price(item.getPrice())
								                                                            .company(
										                                                            item.getCompany())
								                                                            .productLink(
										                                                            item.getProductLink())
								                                                            .build()
				       ))
				       .collect(Collectors.toList());
	}
	
	//	상품명 키워드 검색
	public List<OrderResponse> searchOrdersByProductName(Long memberId, String keyword) {
		Member member = memberRepository.findById(memberId)
				                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
		
		return orderRepository.searchOrdersByProductName(member, keyword)
				       .stream()
				       .flatMap(order -> order.getOrderItems().stream()
						                         .filter(item -> item.getProductName().contains(keyword))
						                         .map(item -> OrderResponse.builder()
								                                      .id(order.getId().toString())
								                                      .status(item.getOrderStatus().name())
								                                      .productName(item.getProductName())
								                                      .productImage(item.getProductImage())
								                                      .orderDate(order.getOrderDate())
								                                      .statusChangedDate(
										                                      item.getStatusChanged())
								                                      .price(item.getPrice())
								                                      .company(item.getCompany())
								                                      .productLink(item.getProductLink())
								                                      .build()))
				       .collect(Collectors.toList());
	}
}
