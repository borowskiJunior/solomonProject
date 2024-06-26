package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.model.UserCourse;
import com.solomon.backend.solomonproject.service.UserService;
import org.springframework.web.bind.annotation.*;

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
        return userService.createUser(user);
    }

    @GetMapping("/login")
    public User loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }

    @PostMapping("/enroll")
    public UserCourse enrollUserToCourse(@RequestParam(name="user_id") Long userId,
                                         @RequestParam(name="course_id") Long courseId){
        return userService.enrollUserToCourse(userId, courseId);
    }

}
