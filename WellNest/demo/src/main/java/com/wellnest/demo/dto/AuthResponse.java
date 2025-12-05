package com.wellnest.demo.dto;

import com.wellnest.demo.model.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

    private boolean success;
    private String message;

    private Role role;             // USER / TRAINER
    private boolean detailsCompleted; // NEW
    private String username;       // email (optional)
}
