package com.cloneproject.demo.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderItem {
	
	private Long id;
	private Long orderId;
	private String productName;
	private String status;
	private Integer price;
	private LocalDateTime statusChangedDate;
}