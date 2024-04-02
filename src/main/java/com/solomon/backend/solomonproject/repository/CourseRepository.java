package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Max Borowski
 */

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course getCourseById(Long id);
}
