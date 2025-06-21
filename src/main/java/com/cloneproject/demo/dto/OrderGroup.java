package com.cloneproject.demo.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderGroup {
	
	private Long id;
	private Long memberId;
	private LocalDateTime orderDate;
}