package com.cloneproject.demo.mainBanner;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "main_banner")
public class MainBanner {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

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
}