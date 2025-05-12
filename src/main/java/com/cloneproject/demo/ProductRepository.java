package com.cloneproject.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Long category);
    List<Product> findByName(String name);
}
