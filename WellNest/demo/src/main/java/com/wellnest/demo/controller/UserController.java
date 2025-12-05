package com.wellnest.demo.controller;

import com.wellnest.demo.dto.UserDetailsResponse;
import com.wellnest.demo.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    @GetMapping("/details")
    public UserDetailsResponse getDetails(@RequestParam String email) {
        return service.getUserDetails(email);
    }
}
