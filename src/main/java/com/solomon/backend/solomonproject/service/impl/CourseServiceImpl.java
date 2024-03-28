package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Course;
import com.solomon.backend.solomonproject.repository.CourseRepository;
import com.solomon.backend.solomonproject.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Max Borowski
 */
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}
