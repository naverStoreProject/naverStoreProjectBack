package com.cloneproject.demo.config;

import com.cloneproject.demo.member.repository.MemberRepository;
import com.cloneproject.demo.mainBanner.MainBannerService;
import com.cloneproject.demo.mainBanner.repository.MainBannerRepository;
import com.cloneproject.demo.mainBanner.repository.mapper.MainBannerMapper;
import com.cloneproject.demo.member.MemberService;
import com.cloneproject.demo.member.repository.mapper.MemberMapper;
import com.cloneproject.demo.order.OrderService;
import com.cloneproject.demo.order.repository.mapper.OrderMapper;
import com.cloneproject.demo.product.repository.mapper.ProductMapper;
import com.cloneproject.demo.product.repository.ProductRepository;
import com.cloneproject.demo.product.ProductService;
import com.cloneproject.demo.review.ReviewService;
import com.cloneproject.demo.review.repository.ReviewRepository;
import com.cloneproject.demo.review.repository.mapper.ReviewMapper;
import com.cloneproject.demo.util.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper; // 'main' 브랜치에서 추가된 부분
    private final EncryptService encryptService;
    private final ReviewRepository reviewRepository;
    private final MainBannerRepository mainBannerRepository; // '00/mainBannerChange/0627' 브랜치에서 추가된 부분

    @Autowired
    public SpringConfig(MemberMapper memberMapper, ProductMapper productMapper,
                        OrderMapper orderMapper, // 'main' 브랜치에서 추가된 부분
                        EncryptService encryptService, ReviewMapper reviewMapper,
                        MainBannerMapper mainBannerMapper) { // '00/mainBannerChange/0627' 브랜치에서 추가된 부분
        this.memberRepository = memberMapper;
        this.productRepository = productMapper;
        this.orderMapper = orderMapper; // 'main' 브랜치에서 추가된 부분
        this.encryptService = encryptService;
        this.reviewRepository = reviewMapper;
        this.mainBannerRepository = mainBannerMapper; // '00/mainBannerChange/0627' 브랜치에서 추가된 부분
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

    @Bean
    OrderService orderService() { // 'main' 브랜치에서 추가된 부분
        return new OrderService(orderMapper);
    }

    @Bean
    public MainBannerService