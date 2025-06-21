package com.cloneproject.demo.orderItem;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderItem {
	
	private Long id;
	private int sequence;
	private Long orderId;
	private String status;
	private String productImage;
	private String productName;
	private int price;
	private String company;
	private LocalDateTime statusChangedDate;
	private String productLink;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
