package com.cloneproject.demo.orderGroup;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderGroup {
	
	private Long id;
	private Long memberId; //FK
	private LocalDateTime orderDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}