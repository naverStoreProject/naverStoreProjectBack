package com.cloneproject.demo.dto;

import com.cloneproject.demo.mainBanner.MainBanner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MainBannerResponse {
  private String title;
  private String semiTitle;
  private String mainImg;
  private String semiImg1;
  private String semiImg2;
  private String semiImg3;
  private String semiImg4;
  private LocalDateTime regDate;
  private String regIp;
  private int isHide;
  private int isDelete;

  // MainBanner 엔티티를 DTO로 변환하는 정적 팩토리 메서드
  public static MainBannerResponse from(MainBanner mainBanner) {
    return MainBannerResponse.builder()
      .title(mainBanner.getTitle())
      .semiTitle(mainBanner.getSemiTitle())
      .mainImg(mainBanner.getMainImg())
      .semiImg1(mainBanner.getSemiImg1())
      .semiImg2(mainBanner.getSemiImg2())
      .semiImg3(mainBanner.getSemiImg3())
      .semiImg4(mainBanner.getSemiImg4())
      .regDate(mainBanner.getRegDate())
      .regIp(mainBanner.getRegIp())
      .isHide(mainBanner.getIsHide())
      .isDelete(mainBanner.getIsDelete())
      .build();
  }

}
