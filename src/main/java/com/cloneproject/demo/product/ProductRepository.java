package com.cloneproject.demo.product;

import com.cloneproject.demo.dto.ProductResponse;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Long category);
    List<Product> findByName(String name);

    @Query(value = "SELECT p.name, p.brand, p.price AS 'original_price', p.discount_rate, (1 - p.discount_rate) * p.price AS 'current_price', p.category, p.stock_quantity, p.description, p.thumbnailurl AS 'image', rs.average_rating, rs.rating_count FROM product p " +
        "JOIN member_wishlist mw ON p.id = mw.product_id " +
        "JOIN member m ON mw.member_id = m.id " +
        "LEFT JOIN review_statistic rs ON p.id = rs.product_id " +
        "WHERE m.id = :id", nativeQuery = true)
    List<Tuple> findWishListByUserId(@Param("id") Long id);



}
