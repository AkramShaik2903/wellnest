package com.wellnest.demo.service;

import com.wellnest.demo.dto.*;

public interface UserService {

    AuthResponse signup(SignupRequest req);

    AuthResponse login(LoginRequest req);

    AuthResponse saveUserDetails(UserDetailsRequest req);

    UserDetailsResponse getUserDetails(String email);  // NEW
}
