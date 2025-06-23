package com.cloneproject.demo.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MemberLoginRequest {

    private String email;
    private String password;

}
