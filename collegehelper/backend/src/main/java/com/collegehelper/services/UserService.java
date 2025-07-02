package com.collegehelper.services;

import com.collegehelper.models.User;
import com.collegehelper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

/**
 * Service for user-related logic: registration, authentication, CRUD.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    /**
     * Register a new user. Returns the created user or null if exists.
     */
    public User registerUser(String username, String password, String role) {
        if (userRepo.findByUsername(username).isPresent()) {
            return null; // user exists
        }
        User user = new User(null, username, password, role.toUpperCase());
        return userRepo.save(user);
    }

    /**
     * Authenticate user by username/password. Returns user if valid, else null.
     */
    public User authenticate(String username, String password) {
        Optional<User> opt = userRepo.findByUsername(username);
        if (opt.isPresent() && opt.get().getPassword().equals(password)) {
            return opt.get();
        }
        return null;
    }

    /**
     * List all users (admin only).
     */
    public List<User> listUsers() {
        return userRepo.findAll();
    }
}
