package com.cloneproject.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrderInfo {
    private Long id;
    private String name;
    private int quantity;
}
