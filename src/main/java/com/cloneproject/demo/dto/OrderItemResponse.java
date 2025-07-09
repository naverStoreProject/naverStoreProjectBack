package com.cloneproject.demo.dto;

import com.cloneproject.demo.order.OrderEnum;
import com.cloneproject.demo.order.OrderItem;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemResponse {
	
	private Long id;
	private Long orderGroupId;
	private String title;
	private String detail;
	private String image;
	private Integer count;
	private Integer price;
	private String link;
	private LocalDateTime orderTime;
	private OrderEnum status;
	private LocalDateTime statusChangedTime;
	private String company;
	
	public static OrderItemResponse from(OrderItem item) {
		OrderItemResponse res = new OrderItemResponse();
		res.id = item.getId();
		res.orderGroupId = item.getOrderGroupId();
		res.title = item.getTitle();
		res.detail = item.getDetail();
		res.image = item.getImage();
		res.count = item.getCount();
		res.price = item.getPrice();
		res.link = item.getLink();
		res.company = item.getCompany();
		res.orderTime = item.getOrderTime();
		res.status = item.getStatus();
		res.statusChangedTime = item.getStatusChangedTime();
		return res;
	}
}
