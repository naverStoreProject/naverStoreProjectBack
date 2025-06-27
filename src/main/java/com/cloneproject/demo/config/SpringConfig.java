package com.cloneproject.demo.config;

import com.cloneproject.demo.member.repository.MemberRepository;
import com.cloneproject.demo.member.MemberService;
import com.cloneproject.demo.member.repository.MemberSpringDataJpaRepository;
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
	private final OrderMapper orderMapper;
	private final EncryptService encryptService;
	private final ReviewRepository reviewRepository;
	
	@Autowired
	public SpringConfig(MemberMapper memberMapper, ProductMapper productMapper,
			OrderMapper orderMapper,
			EncryptService encryptService, ReviewMapper reviewMapper) {
		this.memberRepository = memberMapper;
		this.productRepository = productMapper;
		this.orderMapper = orderMapper;
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
	
	@Bean
	OrderService orderService() {
		return new OrderService(orderMapper);
	}
	
	
}
