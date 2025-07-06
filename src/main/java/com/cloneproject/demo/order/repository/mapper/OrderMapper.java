package com.cloneproject.demo.order.repository.mapper;

import com.cloneproject.demo.order.OrderEnum;
import com.cloneproject.demo.order.OrderItem;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
	
	//memberId로 구매한 주문내역 불러오기
	List<OrderItem> findByMemberId(@Param("memberId") Long memberId);
	
	//	주문 상세 내역
	OrderItem findByMemberIdAndOrderId(@Param("memberId") Long memberId,
			@Param("orderId") Long orderId);
	
	//	주문상태 변경(상태변경 시간도 함께 업데이트)
	int setStatus(@Param("orderId") Long orderId, @Param("status") OrderEnum status,
			@Param("statusChangedTime") LocalDateTime statusChangedTime);
	
	//	배송완료에서 일주일이 지나면 자동으로 구매확정
	int updateStatusToConfirmed();
	
	//	해당 멤버가 구매한 주문내역 수 카운트
	int countOrderItem(@Param("memberId") Long memberId);
	
	//	주문내역 삭제
	int deleteOrderItem(@Param("orderId") Long orderId, @Param("memberId") Long memberId);
	
	//	주문내역 추가
	int insertOrderItem(@Param("orderItem") OrderItem orderItem);
	
}
