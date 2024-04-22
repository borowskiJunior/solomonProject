package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Max Borowski
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public User postUser(@RequestBody User user){
        User userToRegister = userService.createUser(user);
        if(userToRegister == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This login is already exist");
        }
        return userToRegister;
    }

    @GetMapping("/login")
    public User loginUser(@RequestBody User user){
        User userToLogin = userService.loginUser(user);
        if(userToLogin == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login or password is not correct");
        }
        return userToLogin;
    }
}
