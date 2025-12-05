package com.wellnest.demo.dto;

import com.wellnest.demo.model.Role;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignupRequest {

    @Email @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    private Role role;
}
