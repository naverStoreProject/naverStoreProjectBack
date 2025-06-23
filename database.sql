SELECT p.*
FROM product p
         JOIN member_wishlist mw
              ON p.id = mw.product_id
WHERE mw.member_id = 1;


SELECT COUNT(*)
FROM member_wishlist
WHERE member_id = 1;


SELECT p.name,
       p.brand,
       p.price                         AS 'original_price',
       p.discount_rate,
       (1 - p.discount_rate) * p.price AS 'current_price',
       p.category,
       p.stock_quantity,
       p.description,
       p.thumbnailurl                  AS 'image',
       rs.average_rating,
       rs.rating_count
FROM product p
         JOIN member_wishlist mw ON p.id = mw.product_id
         JOIN member m ON mw.member_id = m.id
         LEFT JOIN review_statistic rs ON p.id = rs.product_id
WHERE m.id = 1;

SHOW TABLES;



SELECT *
FROM order_group
WHERE member_id = 1;
SELECT * FROM product;


SELECT r.*, p.id as product_id, p.name, p.brand, p.price, p.discount_rate,
       p.category, p.description, p.stock_quantity, p.thumbnailurl,
       p.created_at as p_created_at
FROM review r
         LEFT JOIN product p
                   ON r.product_id = p.id
WHERE r.member_id = 1;




