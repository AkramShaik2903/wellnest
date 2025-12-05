package com.wellnest.demo.controller;

import com.wellnest.demo.dto.*;
import com.wellnest.demo.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService service;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest req) {
        AuthResponse res = service.signup(req);
        return ResponseEntity.status(res.isSuccess() ? 200 : 400).body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        AuthResponse res = service.login(req);
        return ResponseEntity.status(res.isSuccess() ? 200 : 400).body(res);
    }

    @PostMapping("/save-details")
    public ResponseEntity<AuthResponse> saveDetails(@RequestBody UserDetailsRequest req) {
        AuthResponse res = service.saveUserDetails(req);
        return ResponseEntity.status(res.isSuccess() ? 200 : 400).body(res);
    }
}
