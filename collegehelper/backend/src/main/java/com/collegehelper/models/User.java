package com.collegehelper.models;

import javax.persistence.*;
import lombok.*;

/**
 * User entity.
 * role: STUDENT, MODERATOR, or ADMIN.
 */
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue private Long id;

    @Column(unique=true)
    private String username;

    private String password;

    /**
     * "STUDENT", "MODERATOR", or "ADMIN".
     */
    private String role;
}
