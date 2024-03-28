package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Course;

import java.util.List;

/**
 * @author Max Borowski
 */
public interface CourseService {
    List<Course> getCourses();
    Course getCourse(Long id);
    Course postCourse(Course course);
    void deleteCourse(Long id);
    Course putCourse(Long id, Course course);
}
