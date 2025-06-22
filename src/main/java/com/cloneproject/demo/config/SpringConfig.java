package com.cloneproject.demo.config;

import com.cloneproject.demo.member.repository.MemberRepository;
import com.cloneproject.demo.member.MemberService;
import com.cloneproject.demo.member.repository.MemberSpringDataJpaRepository;
import com.cloneproject.demo.product.repository.mapper.ProductMapper;
import com.cloneproject.demo.product.repository.ProductRepository;
import com.cloneproject.demo.product.ProductService;
import com.cloneproject.demo.util.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final EncryptService encryptService;

    @Autowired
    public SpringConfig(MemberSpringDataJpaRepository memberSpringDataJpaRepository, ProductMapper productMapper, EncryptService encryptService) {
        this.memberRepository = memberSpringDataJpaRepository;
        this.productRepository = productMapper;
        this.encryptService = encryptService;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository, productRepository, encryptService);
    }


    @Bean
    public ProductService productService() {
        return new ProductService(productRepository);
    }


}
