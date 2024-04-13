package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Test;
import com.solomon.backend.solomonproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/lesson/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping()
    public List<Test> getTests(){
        return testService.getTests();
    }

    @GetMapping("/{id}")
    public Test getTest(@PathVariable("id") Long id){
        return testService.getTest(id);
    }

}
