package com.eylul.ecommerce.controllers;

import com.eylul.ecommerce.dto.LoginRequest;
import com.eylul.ecommerce.dto.RegisterRequest;
import com.eylul.ecommerce.models.User;
import com.eylul.ecommerce.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}