package com.cloneproject.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void orderProduct(Long id, int quantity) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            product.get().decreaseQuantity(quantity);
            System.out.println("재고: " + product.get().getStockQuantity());
        }



    }
}
