package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Course;
import com.solomon.backend.solomonproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Max Borowski
 */
@RestController
@RequestMapping("/api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

}
