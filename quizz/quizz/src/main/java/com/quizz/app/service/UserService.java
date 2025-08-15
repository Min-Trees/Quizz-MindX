package com.quizz.app.service;

import com.quizz.app.dto.LoginRequest;
import com.quizz.app.dto.RegisterRequest;
import com.quizz.app.model.Role;
import com.quizz.app.model.User;
import com.quizz.app.repository.UserRepository;
import com.quizz.app.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .roles(Collections.singleton(Role.STUDENT))
                .build();
        userRepository.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}
