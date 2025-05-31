package com.cloneproject.demo.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class LoginMember {
    Long id;
    String email;
    String nickname;
    Integer authority;
}
