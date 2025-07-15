package com.cloneproject.demo.mainBanner.repository;

import java.util.List;
import java.util.Optional;

import com.cloneproject.demo.mainBanner.MainBanner;

public interface MainBannerRepository {
  List<MainBanner> findAll();
  Optional<MainBanner> findById(Long id);
  int save(MainBanner mainBanner);
}
