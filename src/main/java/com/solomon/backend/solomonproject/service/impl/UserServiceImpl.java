package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.repository.UserRepository;
import com.solomon.backend.solomonproject.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Max Borowski
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public User createUser(User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByLogin(user.getLogin()));
        if(userOptional.isPresent()){
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User loginUser(User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword()));
        return userOptional.orElse(null);
    }
}
