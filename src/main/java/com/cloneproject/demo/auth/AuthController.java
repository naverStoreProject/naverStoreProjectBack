package com.cloneproject.demo.auth;

import com.cloneproject.demo.auth.dto.MemberLoginRequest;
import com.cloneproject.demo.auth.dto.TokenResponse;
import com.cloneproject.demo.response.ApiResponse;
import com.cloneproject.demo.response.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody MemberLoginRequest memberLoginRequest) {
        String email = memberLoginRequest.getEmail();
        String pwd = memberLoginRequest.getPassword();

        return ResponseEntity.ok(ApiResponse.success(SuccessCode.LOGIN_SUCCESS, authService.memberLogin(email, pwd)));
    }

}
