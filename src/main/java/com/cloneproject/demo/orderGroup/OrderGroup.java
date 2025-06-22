package com.cloneproject.demo.orderGroup;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderGroup {
	
	private Long id;
	private Long memberId;
	private LocalDateTime orderDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}