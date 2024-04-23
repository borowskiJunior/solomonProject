package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Max Borowski
 */
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    Optional<UserCourse> findByUserIdAndCourseId(Long userId, Long courseId);
}
