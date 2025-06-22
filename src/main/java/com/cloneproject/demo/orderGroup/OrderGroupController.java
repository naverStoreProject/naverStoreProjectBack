package com.cloneproject.demo.orderGroup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order-group")
public class OrderGroupController {
	
	private final OrderGroupService orderGroupService;
	
	@GetMapping("/member/{memberId}")
	public List<OrderGroup> getByMemberId(@PathVariable Long memberId) {
		log.info("요청 들어옴: memberId = {}", memberId); // ✅ 로그 찍기
		List<OrderGroup> groups = orderGroupService.getByMemberId(memberId);
		log.info("조회된 그룹 수: {}", groups.size());
		return groups;
	}
	
	@GetMapping("/{id}")
	public OrderGroup getById(@PathVariable Long id) {
		return orderGroupService.getById(id);
	}
}