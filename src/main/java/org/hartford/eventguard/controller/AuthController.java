package org.hartford.eventguard.controller;

import org.hartford.eventguard.dto.AuthRequest;
import org.hartford.eventguard.dto.AuthResponse;
import org.hartford.eventguard.dto.RegisterRequest;
import org.hartford.eventguard.entity.Role;
import org.hartford.eventguard.entity.User;
import org.hartford.eventguard.repo.RoleRepository;
import org.hartford.eventguard.repo.UserRepository;
import org.hartford.eventguard.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();
        user.setFullName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role customerRole = roleRepository.findByRoleName("CUSTOMER")
                .orElseThrow(() -> new RuntimeException("CUSTOMER role not found"));

        user.getRoles().add(customerRole);

        userRepository.save(user);

        return "Customer registered successfully";
    }
}