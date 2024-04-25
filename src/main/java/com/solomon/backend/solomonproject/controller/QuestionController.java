package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Question;

import com.solomon.backend.solomonproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {
    private final QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }



    @GetMapping()
    public List<Question> getQuestionListByTestId(@RequestParam(name = "test_id", required = false) Long id){
        if(id == null || id == 0){
            return questionService.getQuestions();
        }
        return questionService.getQuestionListByTestId(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id){
        Question question = questionService.getQuestion(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }
}
