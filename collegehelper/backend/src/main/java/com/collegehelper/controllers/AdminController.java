package com.collegehelper.controllers;

import com.collegehelper.models.User;
import com.collegehelper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Admin endpoints for user management, etc.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    /**
     * List all users (admin only).
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.listUsers();
    }
}
