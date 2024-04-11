package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Course;

import java.util.List;

/**
 * @author Max Borowski
 */
public interface CourseService {
    List<Course> getCourses();
    Course getCourse(Long id);
    Course createCourse(Course course);
    void deleteCourse(Long id);
    Course updateCourse(Long id, Course course);
}
