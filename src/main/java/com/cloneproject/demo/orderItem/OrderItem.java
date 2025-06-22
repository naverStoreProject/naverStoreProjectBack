package com.cloneproject.demo.orderItem;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderItem {
	
	private Long id;
	private Integer sequence;
	private Long orderId;
	private OrderItemStatus status;
	private String productImage;
	private String productName;
	private Integer price;
	private String company;
	private LocalDateTime statusChangedDate;
	private String productLink;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}