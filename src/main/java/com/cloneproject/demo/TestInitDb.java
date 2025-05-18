package com.cloneproject.demo;

import com.cloneproject.demo.member.Member;
import com.cloneproject.demo.product.Product;
import com.cloneproject.demo.util.EncryptService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TestInitDb {

    private final InitService initService;

//    @PostConstruct
//    public void init() {
//        initService.dbInit();
//    }




    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        private final EncryptService encryptService;

        public void dbInit() {

//            Member member = new Member("최성보", "최성보", "qwer@naver.com", "1234", "010-1234-5678", "서울특별시", LocalDateTime.now(), false, 1, LocalDateTime.now());
//            em.persist(member);
            String encryptedPwd = encryptService.encryptPwd("qwer1234");
            String encryptedPhone = encryptService.aesEncrypt("010-1234-5678");
            String encryptedAddress = encryptService.aesEncrypt("서울특별시");
            Member member = new Member("최성보", "최성보", "cseongbo17@naver.com", encryptedPwd, encryptedPhone, encryptedAddress, LocalDateTime.now(), false, 1, LocalDateTime.now());
            em.persist(member);

            Product product = new Product("AirForce", 100000, 1L, "신발임.", 10, "", LocalDateTime.now());
            em.persist(product);

        }
    }
}
