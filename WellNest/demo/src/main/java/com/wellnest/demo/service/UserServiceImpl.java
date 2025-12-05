package com.wellnest.demo.service;

import com.wellnest.demo.dto.*;
import com.wellnest.demo.model.*;
import com.wellnest.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    @Override
    public AuthResponse signup(SignupRequest req) {

        if (repo.existsByEmail(req.getEmail())) {
            return AuthResponse.builder()
                    .success(false)
                    .message("User already exists")
                    .build();
        }

        if (!req.getPassword().equals(req.getConfirmPassword())) {
            return AuthResponse.builder()
                    .success(false)
                    .message("Passwords do not match")
                    .build();
        }

        User user = User.builder()
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role(req.getRole() == null ? Role.USER : req.getRole())
                .build();

        repo.save(user);

        return AuthResponse.builder()
                .success(true)
                .message("Account created successfully")
                .role(user.getRole())
                .detailsCompleted(false)
                .username(user.getEmail())
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest req) {

        User user = repo.findByEmail(req.getEmail()).orElse(null);

        if (user == null) {
            return AuthResponse.builder()
                    .success(false)
                    .message("User does not exist")
                    .build();
        }

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            return AuthResponse.builder()
                    .success(false)
                    .message("Incorrect password")
                    .build();
        }

        boolean completed = user.getName() != null;

        return AuthResponse.builder()
                .success(true)
                .message("Login successful")
                .role(user.getRole())
                .detailsCompleted(completed)
                .username(user.getEmail())
                .build();
    }

    @Override
    public AuthResponse saveUserDetails(UserDetailsRequest req) {

        User user = repo.findByEmail(req.getEmail()).orElse(null);

        if (user == null) {
            return new AuthResponse(false, "User not found", null, false, null);
        }

        user.setName(req.getName());
        user.setAge(req.getAge());
        user.setHeight(req.getHeight());
        user.setWeight(req.getWeight());
        user.setGoal(req.getGoal());

        repo.save(user);

        return AuthResponse.builder()
                .success(true)
                .message("Details saved successfully")
                .detailsCompleted(true)
                .role(user.getRole())
                .username(user.getEmail())
                .build();
    }

    @Override
    public UserDetailsResponse getUserDetails(String email) {

    User user = repo.findByEmail(email).orElse(null);

    if (user == null) {
        return null;
    }

    return UserDetailsResponse.builder()
            .email(user.getEmail())
            .name(user.getName())
            .age(user.getAge())
            .height(user.getHeight())
            .weight(user.getWeight())
            .goal(user.getGoal())
            .build();
    }

}
