//도메인
package com.cloneproject.demo.order;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class OrderItem {
	
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
	
	public OrderItem(Long id, Long orderGroupId, String title, String detail, String image,
			Integer count,
			Integer price, String link, LocalDateTime orderTime, OrderEnum status,
			LocalDateTime statusChangedTime,
			String company) {
		this.id = id;
		this.orderGroupId = orderGroupId;
		this.title = title;
		this.detail = detail;
		this.image = image;
		this.count = count;
		this.price = price;
		this.link = link;
		this.orderTime = orderTime;
		this.status = status;
		this.statusChangedTime = statusChangedTime;
		this.company = company;
	}
}
