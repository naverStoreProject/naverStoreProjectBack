package com.cloneproject.demo.orderGroup;

import com.cloneproject.demo.orderGroup.repository.OrderGroupRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderGroupService {
	
	private final OrderGroupRepository orderGroupRepository;
	
	//	회원 주문 그룹 조회
	public List<OrderGroup> getByMemberId(Long memberId) {
		return orderGroupRepository.findByMemberId(memberId);
	}
	
	//	기간 내 주문 그룹 조회
	public List<OrderGroup> getPastYearOrders(Long memberId) {
		return orderGroupRepository.findPastYearByMemberId(memberId);
	}
}
