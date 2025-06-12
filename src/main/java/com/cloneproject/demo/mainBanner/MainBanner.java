package com.cloneproject.demo.mainBanner;

import com.cloneproject.demo.response.CustomException;
import com.cloneproject.demo.response.ErrorCode;
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

/*
 * CREATE TABLE `main_banner` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(100) NOT NULL,
    `main_img` varchar(100) NOT NULL DEFAULT '',
    `semi_img_1` varchar(100) NOT NULL DEFAULT '',
    `semi_img_2` varchar(100) NOT NULL DEFAULT '',
    `semi_img_3` varchar(100) NOT NULL DEFAULT '',
    `semi_img_4` varchar(100) NOT NULL DEFAULT '',
    `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `reg_ip` varchar(50) NOT NULL DEFAULT '',
    `is_hide` tinyint(1) NOT NULL DEFAULT 1,
    `is_delete` tinyint(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */
