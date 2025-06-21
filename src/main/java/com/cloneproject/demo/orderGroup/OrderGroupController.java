package com.cloneproject.demo.orderGroup;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-group")
public class OrderGroupController {
	
	private final OrderGroupService orderGroupService;
	
	//	전체 주문 그룹 조회
	@GetMapping("/member/{memberId}")
	public List<OrderGroup> getByMember(@PathVariable Long memberId) {
		return orderGroupService.getByMemberId(memberId);
	}
	
	//	1년 내 주문 그룹 조회
	@GetMapping("/member/{memberId}/past-year")
	public List<OrderGroup> getPastYear(@PathVariable Long memberId) {
		return orderGroupService.getPastYearOrders(memberId);
	}
}