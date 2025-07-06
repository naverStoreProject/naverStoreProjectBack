//도메인
package com.cloneproject.demo.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
public class OrderGroup {
	
	private Long id;
	private Long memberId;
	
	public OrderGroup(Long id, Long memberId) {
		this.id = id;
		this.memberId = memberId;
	}
}
