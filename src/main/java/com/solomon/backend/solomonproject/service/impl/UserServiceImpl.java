package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Course;
import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.model.UserCourse;
import com.solomon.backend.solomonproject.repository.CourseRepository;
import com.solomon.backend.solomonproject.repository.UserCourseRepository;
import com.solomon.backend.solomonproject.repository.UserRepository;
import com.solomon.backend.solomonproject.service.UserService;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * @author Max Borowski
 */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserCourseRepository userCourseRepository;
    private final CourseRepository courseRepository;
    @Override
    @Transactional
    public User createUser(User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByLogin(user.getLogin()));
        if(userOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This login is already exist");
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User loginUser(User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword()));
        if(userOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login or password is not correct");
        }
//        User getUset = userOptional.get();
//        Hiber
        return userOptional.get();
    }

    @Override
    @Transactional
    public UserCourse enrollUserToCourse(Long userId, Long courseId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Course> courseOptional =  courseRepository.findById(courseId);
        if(userOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this id was not found");
        }
        if(courseOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course with this id was not found");
        }
        UserCourse userCourse = new UserCourse(userOptional.get(), courseOptional.get());

        if(userCourseRepository.findByUserIdAndCourseId(userOptional.get().getId(), courseOptional.get().getId())
                .isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user has already enrolled in the course");
        }
        return userCourseRepository.save(userCourse);
    }

}
