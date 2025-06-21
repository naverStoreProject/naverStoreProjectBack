package com.cloneproject.demo.orderGroup.repository;

import com.cloneproject.demo.orderGroup.OrderGroup;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderGroupRepository {
	
	List<OrderGroup> findByMemberId(Long memberId);
	
	List<OrderGroup> findPastYearByMemberId(Long memberId);
	
	void insert(OrderGroup group);
	
}