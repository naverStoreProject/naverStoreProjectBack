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
            "(name, brand, thumbnail_url, description,  main_category, sub_category, original_price, discount_rate, stock_quantity, average_rating, rating_count, created_at) " +
            "VALUES (#{name}, #{brand}, #{thumbnailURL}, #{description}, #{mainCategory}, #{subCategory}, #{originalPrice}, #{discountRate},  #{stockQuantity}, #{averageRating}, #{ratingCount}, #{createdAt})")
    int save(Product product);



    @Select("SELECT * FROM product WHERE id = #{id}")
    Optional<Product> findById(Long id);

    @Select("SELECT * FROM product")
    List<Product> findAll();

    @Select("SELECT * FROM product WHERE name = #{name}")
    List<Product> findByName(String name);

    @Select("SELECT * FROM product WHERE main_category = #{mainCategory} AND sub_category = #{subCategory}")
    List<Product> findByCategory(Integer mainCategory, Integer subCategory);

    @Select("SELECT * FROM product WHERE main_category = #{mainCategory}")
    List<Product> findByMainCategory(Integer mainCategory);

    @Select("SELECT * FROM product WHERE sub_category = #{subCategory}")
    List<Product> findBySubCategory(Integer subCategory);
}
