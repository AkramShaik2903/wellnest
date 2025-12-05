package com.wellnest.demo.dto;

import lombok.Data;

@Data
public class UserDetailsRequest {

    private String email;
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
    private String goal;
}
