package com.cloneproject.demo.order;

import com.cloneproject.demo.member.Member;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	//	특정 회원의 모든 주문 내역 반환(최신순)
	List<Order> findByMemberOrderByOrderDateDesc(Member member);
	
	//	최근 1년 간 주문내역(최신순)
	List<Order> findByMemberOrderInAYearByOrderDateDesc(Member memeber, LocalDateTime oneYearAgo);
	
	//	검색(한글자라도 포함된 경우)
	@Query("SELECT o FROM Order o JOIN o.orderItems i WHERE o.member=:member AND i.productName LIKE %:keyword% ORDER BY o.orderDate DESC")
	List<Order> searchOrdersByProductName(Member member, String keyword);
}
