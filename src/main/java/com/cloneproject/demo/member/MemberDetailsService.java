package com.cloneproject.demo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을 수 없습니다: " + email));

        // Member 엔티티에서 UserDetails를 직접 구현하거나, 아래처럼 래핑해서 반환
        return org.springframework.security.core.userdetails.User
                .withUsername(member.getEmail())
                .password(member.getPwd())
                .roles(member.getAuthority() == 1 ? "ADMIN" : "USER")
                .build();
    }
}
