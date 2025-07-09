package com.cloneproject.demo.mainBanner.repository.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.cloneproject.demo.mainBanner.MainBanner;
import com.cloneproject.demo.mainBanner.repository.MainBannerRepository;

@Mapper
public interface MainBannerMapper extends MainBannerRepository{
  List<MainBanner> findAll();
  Optional<MainBanner> findById(Long id);
  int save(MainBanner mainBanner);
}
