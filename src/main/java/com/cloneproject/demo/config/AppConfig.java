package com.cloneproject.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    // 비밀번호 해싱용 BCryptPasswordEncoder 빈 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AES 암호화를 위한 AesBytesEncryptor 빈 등록
    @Bean
    public AesBytesEncryptor aesBytesEncryptor() {
        // key와 salt는 실제 환경에서는 환경변수, application.yml 등에서 관리하세요!
        String key = "h1FyM8VzQc0gHrVQzj9iiovlq5mU4Ig/vMHFUE7jDo0="; // 32바이트(256비트) 이상 권장
        String salt = "70726574657374"; // 16진수 16자 이상
        return new AesBytesEncryptor(key, salt);
    }
}

