package com.collegehelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collegehelper.models.User;
import java.util.Optional;

/**
 * Spring Data JPA repository for users.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
