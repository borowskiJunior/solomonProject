package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.model.UserCourse;

/**
 * @author Max Borowski
 */
public interface UserService {
    User createUser(User user);

    User loginUser(User user);

    UserCourse enrollUserToCourse(Long userId, Long courseId);

    User getUserById(Long id);

    User userUpdate(Long id,User userUpdated);
}
