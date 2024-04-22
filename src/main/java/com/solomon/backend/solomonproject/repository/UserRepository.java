package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max Borowski
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    User findByLoginAndPassword(String login, String password);
}
