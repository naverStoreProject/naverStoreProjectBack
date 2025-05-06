package com.cloneproject.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class MemberInfo {
    private Long id;
    private String name; //이름
    private String email;  //이메일
    private LocalDateTime joinDate;
}
