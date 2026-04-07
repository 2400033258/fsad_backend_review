package com.dietary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.dietary.dto.*;
import com.dietary.entity.User;
import com.dietary.service.UserService;
import com.dietary.util.JwtUtil;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        // 👑 ROLE LOGIC
        if (dto.getRole() == null || dto.getRole().isEmpty()) {
            user.setRole("USER");
        } else {
            user.setRole(dto.getRole());
        }

        return ResponseEntity.ok(service.register(user));
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request) {

        Optional<User> user = service.findByEmail(request.getEmail());

        if (user.isPresent() && encoder.matches(request.getPassword(), user.get().getPassword())) {

            String token = jwtUtil.generateToken(user.get().getEmail());

            return ResponseEntity.ok(
                    new AuthResponseDTO(token, user.get().getRole())
            );
        }

        return ResponseEntity.status(401)
                .body(new MessageResponseDTO("Invalid credentials"));
    }
}