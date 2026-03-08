package org.hartford.eventguard.controller;

import org.hartford.eventguard.dto.AuthRequest;
import org.hartford.eventguard.dto.AuthResponse;
import org.hartford.eventguard.dto.RegisterRequest;
import org.hartford.eventguard.service.AuthService;
import org.hartford.eventguard.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    // 🔐 LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getEmail());

        return new AuthResponse(token);
    }

    //  REGISTER CUSTOMER
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.registerCustomer(request);
    }
}