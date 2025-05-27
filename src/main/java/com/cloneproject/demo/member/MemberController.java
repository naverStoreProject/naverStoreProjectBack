package com.cloneproject.demo.member;

import java.util.List;

import com.cloneproject.demo.auth.dto.LoginMember;
import com.cloneproject.demo.dto.MemberResponse;
import com.cloneproject.demo.dto.MemberRegisterRequest;
import com.cloneproject.demo.dto.MemberUpdateRequest;
import com.cloneproject.demo.response.ApiResponse;
import com.cloneproject.demo.response.SuccessCode;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/api/members")
  public ResponseEntity<ApiResponse<List<MemberResponse>>> getMembers(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
    
    if (name != null && email != null) {
      return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_FETCH_SUCCESS, memberService.getMembersByNameAndEmail(name, email)));
    } else if (name != null) {
      return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_FETCH_SUCCESS, memberService.getMembersByName(name)));
    } else if (email != null) {
//      return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_FETCH_SUCCESS, memberService.getMemberByEmail(email)));
    }
    
    return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_FETCH_SUCCESS, memberService.getAllMembers()));
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/api/member/me")
  public ResponseEntity<ApiResponse<MemberResponse>> getMyInfo(@AuthenticationPrincipal LoginMember loginMember) {
    MemberResponse myInfo = memberService.getMemberById(loginMember.getId());
    return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_FETCH_SUCCESS, myInfo));
  }

  /**
   * 주어진 ID에 해당하는 회원 정보를 조회합니다.
   *
   * @param id 조회할 회원의 ID
   * @return 회원 정보가 존재하면 200 OK와 함께 Member 객체를 반환하고,
   *          존재하지 않으면
   *          {
   *              "code": 1001,
   *              "message": "회원 정보를 찾을 수 없습니다."
   *          }
   */
  @GetMapping("/api/member")
  public ResponseEntity<ApiResponse<MemberResponse>> getMember(@RequestParam Long id) {
    return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_FETCH_SUCCESS, memberService.getMemberById(id)));
  }

  /**
   * 전달받은 회원 정보로 회원의 정보를 수정합니다.
   *
   * @param memberUpdateRequest 수정할 회원의 정보 => id(업데이트할 회원의 아이디), name, nickname, email, phone, address 등을 담은 객체
   * @return 업데이트 성공시 200 OK와 함께 회원 정보 업데이트.
   */
  @PostMapping("/api/member/updateMemberInfo")
  public ResponseEntity<ApiResponse<Void>> changeMemberInfo(@RequestBody MemberUpdateRequest memberUpdateRequest) {
    memberService.updateMemberInfo(memberUpdateRequest);
    return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_UPDATE_SUCCESS));
  }


  /**
   * 전달받은 회원가입 정보를 통해 회원 정보를 저장합니다.
   *
   * @param memberRegisterRequest 회원 가입 정보
   * @return 회원 가입 성공시 201 CREATED와 함께 회원 정보가 데이터베이스에 저장됨.
   *          중복된 이메일이면,
   *            {
   *                "code": 1002,
   *                "message": "이미 사용 중인 이메일입니다."
   *            }
   */
  @PostMapping("/api/member/register")
  public ResponseEntity<ApiResponse<Void>> registerMember(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest) {
    memberService.registerMember(memberRegisterRequest);
    return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_CREATE_SUCCESS));
  }

}