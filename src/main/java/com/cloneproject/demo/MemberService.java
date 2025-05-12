package com.cloneproject.demo;

import com.cloneproject.demo.dto.MemberResponse;
import com.cloneproject.demo.dto.MemberRegisterRequest;
import com.cloneproject.demo.dto.MemberUpdateRequest;
import com.cloneproject.demo.response.ErrorCode;
import com.cloneproject.demo.response.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final EncryptService encryptService;


    @Transactional
    public void updateMemberInfo(MemberUpdateRequest memberUpdateRequest) {

        Optional<Member> optMember = memberRepository.findById(memberUpdateRequest.getId());

        if (!optMember.isPresent()) throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);

        Member member = optMember.get();

        if (memberUpdateRequest.getName() != null) member.setName(memberUpdateRequest.getName());
        if (memberUpdateRequest.getNickname() != null) member.setNickname(memberUpdateRequest.getNickname());
        if (memberUpdateRequest.getAddress() != null) {
            String encryptedAddress = encryptService.aesEncrypt(memberUpdateRequest.getAddress());
            member.setAddress(encryptedAddress);
        }
        if (memberUpdateRequest.getPhone() != null) {
            String encryptedPhone = encryptService.aesEncrypt(memberUpdateRequest.getPhone());
            member.setPhone(encryptedPhone);
        }
        if (memberUpdateRequest.getEmail() != null) member.setEmail(memberUpdateRequest.getEmail());

        member.setUpdatedAt(LocalDateTime.now());


    }

    @Transactional
    public void registerMember(MemberRegisterRequest memberRegisterRequest) {

        List<Member> m = memberRepository.findByEmail(memberRegisterRequest.getEmail());
        if (!m.isEmpty()) throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        else {
            String encryptedPwd = encryptService.encryptPwd(memberRegisterRequest.getPwd());
            String encryptedAddress = encryptService.aesEncrypt(memberRegisterRequest.getAddress());
            String encryptedPhone = encryptService.aesEncrypt(memberRegisterRequest.getPhone());
            Member member = new Member(memberRegisterRequest.getName(), memberRegisterRequest.getNickname(), memberRegisterRequest.getEmail(), encryptedPwd, encryptedPhone, encryptedAddress, LocalDateTime.now(), false, memberRegisterRequest.getAuthority(), LocalDateTime.now());
            memberRepository.save(member);
        }

    }

    public MemberResponse getMemberById(Long id) {
        return memberRepository.findById(id)
                .map(member -> {
                    String decryptedAddress = encryptService.aesDecrypt(member.getAddress());
                    String decryptedPhone = encryptService.aesDecrypt(member.getPhone());

                    return new MemberResponse(
                            member.getId(),
                            member.getName(),
                            member.getNickname(),
                            decryptedPhone,
                            decryptedAddress,
                            member.getUpdatedAt(),
                            member.isStatus(),
                            member.getAuthority(),
                            member.getEmail(),
                            member.getJoinDate()
                    );
                })
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

    }

    public List<MemberResponse> getAllMembers() {
        List<Member> members = memberRepository.findAll();

        if (members.isEmpty()) throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        else {
            return members.stream()
                    .map(member -> {
                        String decryptedAddress = encryptService.aesDecrypt(member.getAddress());
                        String decryptedPhone = encryptService.aesDecrypt(member.getPhone());

                        return new MemberResponse(
                                member.getId(),
                                member.getName(),
                                member.getNickname(),
                                decryptedPhone,
                                decryptedAddress,
                                member.getUpdatedAt(),
                                member.isStatus(),
                                member.getAuthority(),
                                member.getEmail(),
                                member.getJoinDate()
                        );
                    }).collect(Collectors.toList());
        }



    }

    public List<MemberResponse> getMembersByNameAndEmail(String name, String email) {
        List<Member> members = memberRepository.findByNameAndEmail(name, email);

        if (members.isEmpty()) throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        else {
            return members.stream()
                    .map(member -> {
                        String decryptedAddress = encryptService.aesDecrypt(member.getAddress());
                        String decryptedPhone = encryptService.aesDecrypt(member.getPhone());

                        return new MemberResponse(
                                member.getId(),
                                member.getName(),
                                member.getNickname(),
                                decryptedPhone,
                                decryptedAddress,
                                member.getUpdatedAt(),
                                member.isStatus(),
                                member.getAuthority(),
                                member.getEmail(),
                                member.getJoinDate()
                        );
                    }).collect(Collectors.toList());
        }
    }

    public List<MemberResponse> getMembersByName(String name) {
        List<Member> members = memberRepository.findByName(name);

        if (members.isEmpty()) throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        else {
            return members.stream()
                    .map(member -> {
                        String decryptedAddress = encryptService.aesDecrypt(member.getAddress());
                        String decryptedPhone = encryptService.aesDecrypt(member.getPhone());

                        return new MemberResponse(
                                member.getId(),
                                member.getName(),
                                member.getNickname(),
                                decryptedPhone,
                                decryptedAddress,
                                member.getUpdatedAt(),
                                member.isStatus(),
                                member.getAuthority(),
                                member.getEmail(),
                                member.getJoinDate()
                        );
                    }).collect(Collectors.toList());
        }


    }

    public List<MemberResponse> getMembersByEmail(String email) {
        List<Member> members = memberRepository.findByEmail(email);

        if (members.isEmpty()) throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        else {
            if (members.isEmpty()) throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
            else {
                return members.stream()
                        .map(member -> {
                            String decryptedAddress = encryptService.aesDecrypt(member.getAddress());
                            String decryptedPhone = encryptService.aesDecrypt(member.getPhone());

                            return new MemberResponse(
                                    member.getId(),
                                    member.getName(),
                                    member.getNickname(),
                                    decryptedPhone,
                                    decryptedAddress,
                                    member.getUpdatedAt(),
                                    member.isStatus(),
                                    member.getAuthority(),
                                    member.getEmail(),
                                    member.getJoinDate()
                            );
                        }).collect(Collectors.toList());
            }
        }
    }


}
