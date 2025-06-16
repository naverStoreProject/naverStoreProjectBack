package com.cloneproject.demo.product.repository.mapper;

import com.cloneproject.demo.product.Product;
import com.cloneproject.demo.product.repository.ProductRepository;
import jakarta.persistence.Tuple;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper extends ProductRepository {

    @Insert("INSERT INTO product (" +
            "VALUES (null, #{name}, #{brand}, #{price}, #{discountRate}, #{category}, #{description}, #{stockQuantity}, #{thumnailURL}, #{createdAt})")
    Product save(Product product);


    @Select("SELECT * FROM product WHERE id = #{id}")
    Optional<Product> findById(Long id);

    @Select("SELECT * FROM product")
    List<Product> findAll();

    @Select("SELECT * FROM product WHERE name = #{name}")
    List<Product> findByName(String name);

    @Select("SELECT * FROM product WHERE category = #{category}")
    List<Product> findByCategory(Long category);


}
