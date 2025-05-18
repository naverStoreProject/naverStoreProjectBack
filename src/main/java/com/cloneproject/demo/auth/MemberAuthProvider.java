package com.cloneproject.demo.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cloneproject.demo.member.MemberService;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class MemberAuthProvider {

    @Value("jwt.secretkey")
    private String secretKey;

    private final MemberService memberService;

    // 토큰 생성 함수.
    public String createToken(Long id) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3_600_000); // 한시간 동안 유효

        return JWT.create()
                .withSubject(String.valueOf(id))
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }


    // 클라이언트가 보낸 토큰 검증하고, 해당 멤버 ID반환 해주는 함수임.
    public Long getMemberIdFromToken(String token) {

        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(secretKey))
                .build()
                .verify(token);

        String subject = jwt.getSubject();
        return Long.parseLong(subject);

    }




}
