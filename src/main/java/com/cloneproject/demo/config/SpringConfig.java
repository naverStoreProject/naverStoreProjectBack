package com.cloneproject.demo.config;

import com.cloneproject.demo.member.repository.MemberRepository;
import com.cloneproject.demo.member.repository.MemberSpringDataJpaRepository;
import com.cloneproject.demo.member.repository.mapper.MemberMapper;
import com.cloneproject.demo.product.repository.mapper.ProductMapper;
import com.cloneproject.demo.product.repository.ProductRepository;
import com.cloneproject.demo.product.repository.mapper.ProductMapper;
import com.cloneproject.demo.product.ProductService;
import com.cloneproject.demo.review.ReviewService;
import com.cloneproject.demo.review.repository.ReviewRepository;
import com.cloneproject.demo.review.repository.mapper.ReviewMapper;
import com.cloneproject.demo.util.EncryptService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final EncryptService encryptService;
    private final ReviewRepository reviewRepository;

    @Autowired
    public SpringConfig(MemberMapper memberMapper, ProductMapper productMapper, EncryptService encryptService, ReviewMapper reviewMapper) {
        this.memberRepository = memberMapper;
        this.productRepository = productMapper;
        this.encryptService = encryptService;
        this.reviewRepository = reviewMapper;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository, productRepository, encryptService);
    }


    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }

    @Bean
    ReviewService reviewService() {
        return new ReviewService(reviewRepository);
    }




}
