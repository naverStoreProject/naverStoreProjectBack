package com.cloneproject.demo.product;

import com.cloneproject.demo.dto.ProductAddRequest;
import com.cloneproject.demo.dto.ProductOrderRequest;
import com.cloneproject.demo.dto.ProductResponse;
import com.cloneproject.demo.product.repository.ProductRepository;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void addProduct(ProductAddRequest productAddRequest) {
        if (!productRepository.findByName(productAddRequest.getName()).isEmpty()) throw new CustomException(ErrorCode.DUPLICATE_PRODUCT);
        Product saveProduct = productAddRequest.toEntity();
        productRepository.save(saveProduct);
    }

    @Transactional
    public void orderProduct(ProductOrderRequest productOrderRequest) {
        Optional<Product> product = productRepository.findById(productOrderRequest.getId());

        if (product.isPresent()) {
            product.get().decreaseQuantity(productOrderRequest.getStockQuantity());
        } else {
            throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        }

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        else {
            return products.stream()
                    .map(product -> ProductResponse.of(product))
                    .toList();
        }

    }


    public List<ProductResponse> getProductsByCategory(Integer mainCategory, Integer subCategory) {
        List<Product> products = productRepository.findByCategory(mainCategory, subCategory);
        if (products.isEmpty()) throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        else {
            return products.stream()
                    .map(product -> ProductResponse.of(product))
                    .toList();
        }
    }


    public ProductResponse getProductById(Long id) {
        Optional<Product> findProduct = productRepository.findById(id);
        if (!findProduct.isPresent()) throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        else {
            return findProduct.map(product -> ProductResponse.of(product)).get();
        }
    }







}
