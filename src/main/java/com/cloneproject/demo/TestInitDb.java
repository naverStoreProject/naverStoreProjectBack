package com.cloneproject.demo;

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

    @PostConstruct
    public void init() {
        initService.dbInit();
    }




    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit() {

            Member member = new Member("최성보", "qwer@naver.com", "1234", LocalDateTime.now());
            em.persist(member);

            Product product = new Product("AirForce", 100000, "Shoes", "신발임.", 10);
            em.persist(product);

        }
    }
}
