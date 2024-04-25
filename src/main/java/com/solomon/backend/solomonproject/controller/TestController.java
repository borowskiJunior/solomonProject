package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Test;
import com.solomon.backend.solomonproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//надо подумать что делать с маппингом
@RestController
@RequestMapping("/v1/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

//    @GetMapping()
//    public List<Test> getTests(){
//        return testService.getTests();
//    }

    @GetMapping()
    public Test getTestByLessonId(@RequestParam(name="lesson_id") Long id){
        return testService.getTestByLessonId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTest(@PathVariable("id") Long id){
        Test test = testService.getTest(id);
        if (test == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(test);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Test delTest = testService.getTest(id);
        if(delTest == null)
            return ResponseEntity.notFound().build();

        testService.deleteTest(delTest.getId());
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Test test){
        testService.saveTest(test);
        return ResponseEntity.ok("New test is created");
    }


}
