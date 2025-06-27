package com.cloneproject.demo.dto;

import com.cloneproject.demo.order.OrderItem;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemRequest {
	
	@NotNull
	private Long orderGroupId;
	
	@NotNull
	private String title;
	
	private String detail;
	private String image;
	private Integer count;
	private Integer price;
	private String link;
	private String company;
	
	// 필요하다면 추가 필드
	
	// 도메인 객체로 변환하는 메서드
	public OrderItem toEntity() {
		OrderItem item = new OrderItem();
		item.setOrderGroupId(this.orderGroupId);
		item.setTitle(this.title);
		item.setDetail(this.detail);
		item.setImage(this.image);
		item.setCount(this.count);
		item.setPrice(this.price);
		item.setLink(this.link);
		item.setCompany(this.company);
		// memberId, orderTime, status 등은 Service에서 세팅
		return item;
	}
}