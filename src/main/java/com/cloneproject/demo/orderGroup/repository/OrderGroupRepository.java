package com.cloneproject.demo.orderGroup.repository;

import com.cloneproject.demo.orderGroup.OrderGroup;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderGroupRepository {
	
	List<OrderGroup> findByMemberId(Long memberId);
	
	OrderGroup findById(Long id);
}