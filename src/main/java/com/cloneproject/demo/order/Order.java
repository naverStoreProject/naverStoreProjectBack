package com.cloneproject.demo.order;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Enumerated(EnumType.STRING)
	@Setter
	private OrderStatus status;
	
	@Setter
	private String productName;
	
	@Setter
	private String productImage;
	
	@Setter
	private LocalDateTime orderDate; //주문 시점
	
	@Setter
	private LocalDateTime statusChangedDate; //상태 변경 시점
	
	@Setter
	private int price;
	
	@Setter
	private String company;
	
	@Setter
	private String productLink; //상품 링크
	
	public Order(String id, OrderStatus status, String productName, String productImage,
			LocalDateTime orderDate, LocalDateTime statusChangedDate, int price, String company,
			String productLink) {
		this.id = id;
		this.status = status;
		this.productName = productName;
		this.productImage = productImage;
		this.orderDate = orderDate;
		this.statusChangedDate = statusChangedDate;
		this.price = price;
		this.company = company;
		this.productLink = productLink;
	}
}
