package com.cloneproject.demo.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MyInfo {
    private String name;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private int wishNum;
}
