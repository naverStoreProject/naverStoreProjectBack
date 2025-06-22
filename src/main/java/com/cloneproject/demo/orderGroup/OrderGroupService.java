package com.cloneproject.demo.orderGroup;

import com.cloneproject.demo.orderGroup.repository.OrderGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderGroupService {
	
	private final OrderGroupRepository orderGroupRepository;
	
	public List<OrderGroup> getByMemberId(Long memberId) {
		log.info("OrderGroupService.getByMemberId 실행: memberId = {}", memberId);
		return orderGroupRepository.findByMemberId(memberId);
	}
	
	public OrderGroup getById(Long id) {
		return orderGroupRepository.findById(id);
	}
}