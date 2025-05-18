package com.cloneproject.demo.config;

import com.cloneproject.demo.auth.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 웹 보안 활성화
@EnableMethodSecurity(prePostEnabled = true) // @PreAuthorize("hasRole('USER')") 같은 어노테이션을 컨트롤러 메서드에 사용 가능하게 해줍니다. 메서드 호출 전에 권한을 체크하여, 예: USER 권한이 있는 사용자만 접근 허용.
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF(사이트 간 요청 위조) 비활성화 (API 서버인 경우 주로 사용). JWT 토큰을 이용해 인증하기 때문에 필요 없음.
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 모든 요청 허용
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);    // UsernamePasswordAuthenticationFilter는 폼 로그인 요청 처리, JWT 기반 인증은 로그인 후 발급된 토큰을 검증해야 하므로 그보다 앞에서 처리되어야 함.
        return http.build();
    }
}
