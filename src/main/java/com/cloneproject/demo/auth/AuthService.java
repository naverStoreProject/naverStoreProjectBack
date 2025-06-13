package com.cloneproject.demo.auth;

import com.cloneproject.demo.auth.dto.TokenResponse;
import com.cloneproject.demo.member.Member;
import com.cloneproject.demo.member.repository.MemberSpringDataJpaRepository;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberSpringDataJpaRepository memberSpringDataJpaRepository;
    private final MemberAuthProvider memberAuthProvider;
    private final PasswordEncoder passwordEncoder;


    public TokenResponse memberLogin(String email, String pwd) {
        Optional<Member> findMember = memberSpringDataJpaRepository.findByEmail(email);

        if (!findMember.isPresent()) throw new CustomException(ErrorCode.INVALID_EMAIL);

        Member member = findMember.get();

        if (!passwordEncoder.matches(pwd, member.getPwd())) throw new CustomException(ErrorCode.INVALID_PASSWORD);

        String accessToken = memberAuthProvider.createToken(member.getId());

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);

        return tokenResponse;



    }

}
