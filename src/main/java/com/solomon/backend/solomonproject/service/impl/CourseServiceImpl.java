package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.dto.*;
import com.solomon.backend.solomonproject.model.*;
import com.solomon.backend.solomonproject.repository.CourseRepository;
import com.solomon.backend.solomonproject.service.CourseService;
import com.solomon.backend.solomonproject.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Max Borowski
 */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final TestService testService;
    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDTO getCourse(Long id) {

        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет курса по данному course_id");

        Course course = optionalCourse.get();
        CourseDTO courseDTO = new CourseDTO(course.getId(), course.getTitle(), course.getDescription(), course.getAuthor(), course.getPrice(), Collections.emptyList());

        return courseDTO;
    }

    @Override
    @Transactional
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    @Transactional
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
        List<Course> courses = courseRepository.findCoursesByUserId(userId);
        if(courses.isEmpty()){
            return Collections.emptyList();
        }
        return courses;
    }

    @Override
    public CourseDTO getAllInformationAboutCourse(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if(optionalCourse.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет курса по данному course_id");

        Course course = optionalCourse.get();

        List<ChapterDTO> chapterDTOList = new ArrayList<>();
        for(Chapter chapter : course.getChapters()){
            List<LessonDTO> lessonDTOList = new ArrayList<>();
            for(Lesson lesson : chapter.getLessons()){
                Test test = lesson.getTest();
                if(test == null)
                    continue;
                List<QuestionDTO> questionDTOList = new ArrayList<>();
                for (Question question : test.getQuestions()) {
                    List<AnswerDTO> answerDTOList = new ArrayList<>();
                    for (Answer answer : question.getAnswers()) {
                        answerDTOList.add(new AnswerDTO(answer.getId(), answer.getAns(), answer.isCorrect()));
                    }
                    questionDTOList.add(new QuestionDTO(question.getId(), question.getQuest(), answerDTOList));
                }
                TestDTO testDTO = new TestDTO(test.getId(), test.getName(), test.getRunTime(), Collections.emptyList());
                lessonDTOList.add(new LessonDTO(lesson.getId(), lesson.getOrdinalNumber(), lesson.getName(), lesson.getText(), testDTO));
            }
            chapterDTOList.add(new ChapterDTO(chapter.getId(), chapter.getOrdinalNumber(), chapter.getName(), chapter.getDescription(),lessonDTOList));
        }

        CourseDTO courseDTO = new CourseDTO(course.getId(), course.getTitle(), course.getDescription(),course.getAuthor(), course.getPrice(), chapterDTOList);
        return courseDTO;
    }
}
