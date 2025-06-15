package com.cloneproject.demo.order;

import com.cloneproject.demo.member.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	//	특정 회원의 모든 주문 내역
	List<Order> findByMember(Member member);
	
	//	특정 회원+상태별 주문
	List<Order> findByMemberAndStatus(Member member, OrderStatus status);
	
	//	상태별 수량 조회
	@Query("SELECT COUNT(o) FROM Order o WHERE o.status=:status")
	int countByStatus(@Param("status") OrderStatus status);
	
	//	특정 회원의 주문 중 주문확정 상태의 총 금액
	@Query("SELECT SUM(o.price) FROM Order o WHERE o.WHERE o.member.id=:memberId AND o.status=:status")
	Integer sumPriceByMemberAndStatus(@Param("memberId") Long memberId,
			@Param("status") OrderStatus status);
}
