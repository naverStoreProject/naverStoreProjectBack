package com.cloneproject.demo.dto;

import com.cloneproject.demo.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class MemberResponse {
    private Long id;
    private String name; //이름
    private String nickname;
    private String phone;
    private String address;
    private LocalDateTime updatedAt;
    private boolean status;
    private Integer authority;
    private String email;  //이메일
    private LocalDateTime joinDate;

    @Builder
    public MemberResponse(Long id, String name, String nickname, String phone, String address, LocalDateTime updatedAt, boolean status, Integer authority, String email, LocalDateTime joinDate) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.updatedAt = updatedAt;
        this.status = status;
        this.authority = authority;
        this.email = email;
        this.joinDate = joinDate;
    }

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.nickname = member.getNickname();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.updatedAt = member.getUpdatedAt();
        this.status = member.isStatus();
        this.authority = member.getAuthority();
        this.email = member.getEmail();
        this.joinDate = member.getJoinDate();
    }

}
