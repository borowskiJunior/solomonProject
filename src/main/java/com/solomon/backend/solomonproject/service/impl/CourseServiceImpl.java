package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Course;
import com.solomon.backend.solomonproject.repository.CourseRepository;
import com.solomon.backend.solomonproject.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Course getCourse(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Course updateCourse(Long id, Course course) {
        Course currentCourse = courseRepository.getCourseById(id);

        currentCourse.setAuthor(course.getAuthor());
        currentCourse.setPrice(course.getPrice());
        currentCourse.setTitle(course.getTitle());
        currentCourse.setDescription(course.getDescription());

        return courseRepository.save(currentCourse);
    }

    @Override
    @Transactional
    public Course updateSomeFieldsCourse(Long id, Course course) {
        Course currentCourse = courseRepository.getCourseById(id);

        Optional.ofNullable(course.getAuthor()).ifPresent(currentCourse::setAuthor);
        Optional.ofNullable(course.getTitle()).ifPresent(currentCourse::setTitle);
        Optional.ofNullable(course.getDescription()).ifPresent(currentCourse::setDescription);
        Optional.ofNullable(course.getPrice()).ifPresent(currentCourse::setPrice);

        return courseRepository.save(currentCourse);
    }

    @Override
    public List<Course> getCoursesByUserId(Long userId) {
        return courseRepository.findCoursesByUserId(userId);
    }

}
