package com.cloneproject.demo;

import com.cloneproject.demo.dto.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void changeName(Long id, String name) {
        Optional<Member> member = memberRepository.findById(id);

        member.ifPresent(value -> value.changeName(name));
    }

    @Transactional
    public void changeMemberInfo(MemberInfo memberInfo) {
        Optional<Member> member = memberRepository.findById(memberInfo.getId());

        if (member.isPresent()) {

            if (memberInfo.getName() != null) {
                member.get().changeName(memberInfo.getName());
            } else if (memberInfo.getEmail() != null) {
                member.get().changeEmail(memberInfo.getEmail());
            }

        }
    }


}
