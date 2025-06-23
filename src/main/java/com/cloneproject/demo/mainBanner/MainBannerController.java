package com.cloneproject.demo.mainBanner;

import com.cloneproject.demo.dto.MainBannerResponse;
import com.cloneproject.demo.response.ApiResponse;
import com.cloneproject.demo.response.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainBannerController {

  private final MainBannerService mainBannerService;

  @GetMapping("/api/mainBanners")
  public ResponseEntity<ApiResponse<List<MainBannerResponse>>> getAllMainBanner() {

      List<MainBannerResponse> mbanners;
      mbanners = mainBannerService.getAllMainBanner();

      return ResponseEntity.ok(
          ApiResponse.success(SuccessCode.MB_FETCH_SUCCESS, mbanners)
      );
  }
}
