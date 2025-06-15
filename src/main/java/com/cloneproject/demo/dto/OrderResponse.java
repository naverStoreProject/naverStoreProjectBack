package com.cloneproject.demo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderResponse {
	
	private String id;
	private String status;
	private String productName;
	private String productImage;
	private LocalDateTime orderDate;
	private LocalDateTime statusChangedDate;
	private int price;
	private String company;
	private String productLink;
}
