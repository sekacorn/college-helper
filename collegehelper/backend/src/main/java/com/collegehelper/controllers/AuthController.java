package com.collegehelper.controllers;

import com.collegehelper.dto.LoginRequest;
import com.collegehelper.dto.RegisterRequest;
import com.collegehelper.models.User;
import com.collegehelper.security.JwtUtil;
import com.collegehelper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Handles registration and authentication endpoints.
 * Note: For real apps, always hash passwords!
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Register a new user (Student/Moderator/Admin).
     */
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        User created = userService.registerUser(req.getUsername(), req.getPassword(), req.getRole());
        return (created != null) ? "Registered!" : "User exists!";
    }

    /**
     * Authenticate user and return JWT on success.
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        User user = userService.authenticate(req.getUsername(), req.getPassword());
        return (user != null)
                ? jwtUtil.generateToken(user.getUsername(), user.getRole())
                : "Invalid!";
    }
}
