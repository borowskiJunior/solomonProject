package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Max Borowski
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
