package com.cloneproject.demo;

import com.cloneproject.demo.dto.ProductOrderRequest;
import com.cloneproject.demo.dto.ProductResponse;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void addProduct(ProductResponse productResponse) {
        if (!productRepository.findByName(productResponse.getName()).isEmpty()) throw new CustomException(ErrorCode.DUPLICATE_PRODUCT);
        Product saveProduct = productResponse.toEntity();
        productRepository.save(saveProduct);
    }

    @Transactional
    public void orderProduct(ProductOrderRequest productOrderRequest) {
        Optional<Product> product = productRepository.findById(productOrderRequest.getId());

        if (product.isPresent()) {
            product.get().decreaseQuantity(productOrderRequest.getQuantity());
        } else {
            throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        }

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        else {
            return products.stream()
                    .map(product -> new ProductResponse(product))
                    .toList();
        }

    }


    public List<ProductResponse> getProductsByCategory(Long category) {
        List<Product> products = productRepository.findByCategory(category);
        if (products.isEmpty()) throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        else {
            return products.stream()
                    .map(product -> new ProductResponse(product))
                    .toList();
        }
    }





}
