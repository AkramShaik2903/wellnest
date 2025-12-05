package com.wellnest.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsResponse {

    private String email;
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
    private String goal;
}
