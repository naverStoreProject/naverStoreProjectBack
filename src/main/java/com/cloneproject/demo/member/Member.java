package com.cloneproject.demo.member;

/**
 * 이 페이지는 DB에 있는거 그대로 따라하면 됨
 */

// 필수
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//유틸
import lombok.*;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class Member {
  //auto increment
  @Id @GeneratedValue( strategy =  GenerationType.IDENTITY)
  private Long id;

  @Setter
  private String name; //이름
  @Setter
  private String nickname;
  @Setter
  private String email;  //이메일

  private String pwd; //sha256

  @Setter
  private String phone;
  @Setter
  private String address;
  @Setter
  private LocalDateTime updatedAt;
  @Setter
  private boolean status;
  @Setter
  private Integer authority;

  private LocalDateTime joinDate; //회원가입일


  public Member(String name, String nickname, String email, String pwd, String phone, String address, LocalDateTime updatedAt, boolean status, Integer authority, LocalDateTime joinDate) {
    this.name = name;
    this.nickname = nickname;
    this.email = email;
    this.pwd = pwd;
    this.phone = phone;
    this.address = address;
    this.updatedAt = updatedAt;
    this.status = status;
    this.authority = authority;
    this.joinDate = joinDate;
  }

}
