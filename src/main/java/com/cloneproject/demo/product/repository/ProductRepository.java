package com.cloneproject.demo.product.repository;

import com.cloneproject.demo.product.Product;
import jakarta.persistence.Tuple;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    int save(Product product);

    Optional<Product> findById(Long id);
    List<Product> findAll();

    List<Product> findByName(String name);
    List<Product> findByCategory(Integer mainCategory, Integer subCategory);
    List<Product> findByMainCategory(Integer mainCategory);
    List<Product> findBySubCategory(Integer subCategory);

}
