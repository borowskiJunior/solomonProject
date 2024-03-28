package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Course;

import java.util.List;

/**
 * @author Max Borowski
 */
public interface CourseService {
    List<Course> getCourses();
}
