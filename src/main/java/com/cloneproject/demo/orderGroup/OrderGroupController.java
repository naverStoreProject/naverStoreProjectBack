package com.cloneproject.demo.orderGroup;

import java.util.Collections;
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
		System.out.println("🔥🔥🔥🔥 Controller 진입 시도됨");
		log.info("요청 들어옴: memberId = {}", memberId);
		List<OrderGroup> groups = orderGroupService.getByMemberId(memberId);
		if (groups == null) {
			log.error("orderGroupService.getByMemberId()가 null을 반환함");
			return Collections.emptyList(); // 또는 throw new CustomException()
		}
		log.info("조회된 그룹 수: {}", groups.size());
		return groups;
	}
	
	@GetMapping("/{id}")
	public OrderGroup getById(@PathVariable Long id) {
		return orderGroupService.getById(id);
	}
}