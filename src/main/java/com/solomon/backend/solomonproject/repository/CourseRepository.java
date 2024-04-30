package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Max Borowski
 */

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course getCourseById(Long id);
    @Query("SELECT uc.course FROM UserCourse uc WHERE uc.user.id = :userId")
    List<Course> findCoursesByUserId(@Param("userId") Long userId);
}
