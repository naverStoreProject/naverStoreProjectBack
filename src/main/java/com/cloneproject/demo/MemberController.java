package com.cloneproject.demo;

import java.util.List;
import java.util.Optional;

import com.cloneproject.demo.dto.MemberInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
  
  private final MemberRepository memberRepository;
  private final MemberService memberService;

  @GetMapping("/api/members")
  public List<Member> getMembers(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
    
    if (name != null && email != null) {
      return memberRepository.findByNameAndEmail(name, email);
    } else if (name != null) {
      return memberRepository.findByName(name);
    } else if (email != null) {
      return memberRepository.findByEmail(email);
    }
    
    return memberRepository.findAll();
  }

  /**
   * 주어진 ID에 해당하는 회원 정보를 조회합니다.
   *
   * @param id 조회할 회원의 ID
   * @return 회원 정보가 존재하면 200 OK와 함께 Member 객체를 반환하고,
   *         존재하지 않으면 404 Not Found 상태를 반환합니다.
   */
  @GetMapping("/api/member")
  public ResponseEntity<Member> getMember(@RequestParam Long id) {
    Optional<Member> member = memberRepository.findById(id);

    return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

  }

  /**
   * 전달받은 회원 정보로 회원의 정보를 수정합니다.
   *
   * @param memberInfo 수정할 회원의 정보(id, name, email 등)를 담은 객체
   */
  @PostMapping("/api/changeMemberInfo")
  public void changeMemberInfo(@RequestBody MemberInfo memberInfo) {
    memberService.changeMemberInfo(memberInfo);
  }

}