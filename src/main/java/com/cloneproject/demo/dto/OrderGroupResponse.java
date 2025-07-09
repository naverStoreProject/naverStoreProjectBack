package com.cloneproject.demo.dto;

import com.cloneproject.demo.order.OrderGroup;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderGroupResponse {
	
	private Long id;
	private Long memberId;
	
	@Builder
	public OrderGroupResponse(Long id, Long memberId) {
		this.id = id;
		this.memberId = memberId;
	}
	
	public OrderGroupResponse(OrderGroup orderGroup) {
		this.id = id;
		this.memberId = memberId;
	}
	
}
