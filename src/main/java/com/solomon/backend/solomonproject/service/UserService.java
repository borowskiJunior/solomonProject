package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.User;

/**
 * @author Max Borowski
 */
public interface UserService {
    User createUser(User user);

    User loginUser(User user);
}
