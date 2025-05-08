package com.cloneproject.demo;

/**
 * 이 페이지는 DB에 있는거 그대로 따라하면 됨
 */

// 필수
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//유틸
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class Member {
  //auto increment
  @Id @GeneratedValue( strategy =  GenerationType.IDENTITY)
  private Long id;

  private String name; //이름
  private String email;  //이메일
  private String pwd; //sha256
  private LocalDateTime joinDate; //회원가입일

  public Member(String name, String email, String pwd, LocalDateTime joinDate) {
    this.name = name;
    this.email = email;
    this.pwd = pwd;
    this.joinDate = joinDate;
  }

  public void changePwd(String pwd) {
    this.pwd = pwd;
  }

  public void changeName(String name) {
    this.name = name;
  }

  public void changeEmail(String email) {
    this.email = email;
  }

}
