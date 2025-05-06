package com.cloneproject.demo;

import com.cloneproject.demo.dto.OrderInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    /**
     * 주문 요청을 처리하는 API 엔드포인트입니다.
     * 클라이언트로부터 상품 ID와 수량을 전달받아 주문을 처리하고, 재고를 감소시킵니다.
     * @param orderInfo (id, name, quantity)  json
     * @return 주문 처리 결과 메시지를 담은 HTTP 응답
     */
    @PostMapping("/api/order")
    public ResponseEntity<String> orderProduct(@RequestBody OrderInfo orderInfo) {
        productService.orderProduct(orderInfo.getId(), orderInfo.getQuantity());
        return ResponseEntity.status(HttpStatus.OK).body("주문이 완료되었습니다.");
    }

    /**
     * 주어진 카테고리에 해당하는 상품 목록을 조회합니다.
     *
     * @param category 조회할 상품의 카테고리
     * @return 해당 카테고리에 속하는 상품 목록
     */
    @GetMapping("/api/products")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productRepository.findByCategory(category);
    }

}
