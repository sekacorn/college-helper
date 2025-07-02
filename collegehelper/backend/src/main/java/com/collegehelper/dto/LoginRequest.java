package com.collegehelper.dto;

import lombok.*;

/**
 * Login request DTO.
 */
@Getter @Setter
public class LoginRequest {
    private String username;
    private String password;
}