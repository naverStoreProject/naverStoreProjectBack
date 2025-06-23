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

    @Insert("INSERT INTO product " +
            "VALUES (null, #{name}, #{brand}, #{thumbnailUrl}, #{description}, #{mainCategory}, #{subCategory}, #{originalPrice}, #{discountRate}, #{stockQuantity}, #{averageRating}, #{ratingCount}, #{createdAt})")
    void save(Product product);
//    Product save(Product product);


    @Select("SELECT * FROM product WHERE id = #{id}")
    Optional<Product> findById(Long id);

    @Select("SELECT * FROM product")
    List<Product> findAll();

    @Select("SELECT * FROM product WHERE name = #{name}")
    List<Product> findByName(String name);

    @Select("SELECT * FROM product WHERE main_category = #{mainCategory} AND sub_category = #{subCategory}")
    List<Product> findByCategory(Integer mainCategory, Integer subCategory);


}
