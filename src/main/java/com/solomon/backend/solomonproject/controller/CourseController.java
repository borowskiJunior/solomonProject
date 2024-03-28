package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Course;
import com.solomon.backend.solomonproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }

    @PostMapping("/course")
    public Course postCourse(@RequestBody Course course){
        return courseService.postCourse(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
    }

    @PutMapping("/course/{id}")
    public Course putCourse(@PathVariable("id") Long id, @RequestBody Course course){
        return courseService.putCourse(id, course);
    }
}
