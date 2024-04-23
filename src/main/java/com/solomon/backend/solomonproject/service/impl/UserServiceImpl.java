package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.repository.UserRepository;
import com.solomon.backend.solomonproject.service.UserService;
import lombok.AllArgsConstructor;
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
    public User loginUser(User user) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword()));
        if(userOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login or password is not correct");
        }
        return userOptional.get();
    }
}
