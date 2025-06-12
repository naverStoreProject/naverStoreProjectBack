package com.cloneproject.demo.mainBanner;

import com.cloneproject.demo.dto.MainBannerResponse;
import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainBannerService {
  private final MainBannerRepository mainBannerRepository;

  public List<MainBannerResponse> getAllMainBanner() {
    List<MainBanner> mbanners = mainBannerRepository.findAll();

    if (mbanners.isEmpty()) {
        throw new CustomException(ErrorCode.MAINBANNER_NOT_FOUND);
    }
    else {
      return mbanners.stream()
          .map(MainBannerResponse::from)
          .toList();
    }
  }

  public List<MainBannerResponse> getMainBanner(Long id) {
    MainBanner mbanner = mainBannerRepository.findById(id)
      .orElseThrow(() -> new CustomException(ErrorCode.MAINBANNER_NOT_FOUND));

    return List.of(MainBannerResponse.from(mbanner));
  }

}
