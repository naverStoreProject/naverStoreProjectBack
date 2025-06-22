package com.cloneproject.demo.product;

import com.cloneproject.demo.dto.ProductAddRequest;
import com.cloneproject.demo.dto.ProductOrderRequest;
import com.cloneproject.demo.dto.ProductResponse;
import com.cloneproject.demo.response.ApiResponse;
import com.cloneproject.demo.response.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/api/product/add")
    public ResponseEntity<ApiResponse<Void>> addProduct(@RequestBody ProductAddRequest productAddRequest) {
        productService.addProduct(productAddRequest);
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.PRODUCT_SAVE_SUCCESS));
    }

    /**
     * 주문 요청을 처리하는 API 엔드포인트입니다.
     * 클라이언트로부터 상품 ID와 수량을 전달받아 주문을 처리하고, 재고를 감소시킵니다.
     * @param productOrderRequest (id, name, quantity)  json
     * @return 주문 처리 결과 메시지를 담은 HTTP 응답
     */
    @PostMapping("/api/product/order")
    public ResponseEntity<ApiResponse<Void>> orderProduct(@RequestBody ProductOrderRequest productOrderRequest) {
        productService.orderProduct(productOrderRequest);
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.PRODUCT_ORDER_SUCCESS));
    }

    /**
     * 주어진 카테고리에 해당하는 상품 목록을 조회합니다.
     *
     * @param category 조회할 상품의 카테고리(null이어도 가능)
     * @return category가 null이면 상품 전체 조회, null이 아니라면 해당 카테고리의 product 조회
     */
    @GetMapping("/api/products")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProductsByCategory(@RequestParam(required = false) Long category) {
        if (category == null) return ResponseEntity.ok(ApiResponse.success(SuccessCode.PRODUCT_FETCH_SUCCESS, productService.getAllProducts()));
        else return ResponseEntity.ok(ApiResponse.success(SuccessCode.PRODUCT_FETCH_SUCCESS, productService.getProductsByCategory(category)));
    }

    @GetMapping("/api/product")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@RequestParam Long id) {
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.PRODUCT_FETCH_SUCCESS, productService.getProductById(id)));
    }



}
