package com.cloneproject.demo.product.repository;

import com.cloneproject.demo.product.Product;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductSpringDataJpaRepository /* extends JpaRepository<Product, Long>, ProductRepository */{
    List<Product> findByCategory(Integer mainCategory, Integer subCategory);
    List<Product> findByName(String name);





}
