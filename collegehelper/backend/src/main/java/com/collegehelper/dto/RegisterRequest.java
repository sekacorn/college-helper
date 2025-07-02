package com.collegehelper.dto;

import lombok.*;
/**
 * Register request DTO.
 */
@Getter @Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String role;
}