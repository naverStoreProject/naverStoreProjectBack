package com.cloneproject.demo.orderGroup.repository;

import com.cloneproject.demo.orderGroup.OrderGroup;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderGroupRepository {
	
	List<OrderGroup> findAll();
	
	OrderGroup findById(Long id);
	
	void insert(OrderGroup orderGroup);
	
	void update(OrderGroup orderGroup);
	
	void delete(Long id);
}