package com.cloneproject.demo.product.repository.mapper;

import com.cloneproject.demo.product.Product;
import com.cloneproject.demo.product.repository.ProductRepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper extends ProductRepository {

    @Insert("INSERT INTO product " +
            "(name, brand, price, discount_rate, category, description, stock_quantity, thumbnail_url, created_at) " +
            "VALUES (#{name}, #{brand}, #{price}, #{discountRate}, #{category}, #{description}, #{stockQuantity}, #{thumbnailURL}, #{createdAt})")
    int save(Product product);



    @Select("SELECT * FROM product WHERE id = #{id}")
    Optional<Product> findById(Long id);

    @Select("SELECT * FROM product")
    List<Product> findAll();

    @Select("SELECT * FROM product WHERE name = #{name}")
    List<Product> findByName(String name);

    @Select("SELECT * FROM product WHERE main_category = #{mainCategory} AND sub_category = #{subCategory}")
    List<Product> findByCategory(Integer mainCategory, Integer subCategory);


}
