package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.repository.UserRepository;
import com.solomon.backend.solomonproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Max Borowski
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
