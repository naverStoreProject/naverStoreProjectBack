package com.cloneproject.demo.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MemberUpdateRequest {
    private Long id;
    private String name;
    private String nickname;

    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "올바른 이메일 형식이 아닙니다."
    )   // 이메일 유효성 검사 정규식
    private String email;

    @Pattern(
            regexp = "^(01[016789]-\\d{4}-\\d{4}|0\\d{1,2}-\\d{3,4}-\\d{4})$",
            message = "올바른 전화번호 형식이 아닙니다."
    ) // 전화번호 유효성 검사 정규식 -> 유선전화 + 휴대전화 ('-' 하이픈 필수!)
    private String phone;

    private String address;

}
