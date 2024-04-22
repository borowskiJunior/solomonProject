package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Course;
import com.solomon.backend.solomonproject.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Max Borowski
 */
@RestController
@RequestMapping("/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public List<Course> getCourses(@RequestParam(name = "user_id", required = false) Long userId){
        if(userId == null || userId == 0){
            return courseService.getCourses();
        }
        return courseService.getCoursesByUserId(userId); //ОБРАБОТАЙ ИСКЛЮЧЕНИЯ!
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }

    @PostMapping("/course")
    public Course postCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
    }

    @PutMapping("/course/{id}")
    public Course putCourse(@PathVariable("id") Long id, @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }

    @PatchMapping("/course/{id}")
    public Course patchCourse(@PathVariable("id") Long id, @RequestBody Course course){
        return courseService.updateSomeFieldsCourse(id, course);
    }
}
