package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Question;

import com.solomon.backend.solomonproject.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {
    private final QuestionsService questionsService;
    @Autowired
    public QuestionController(QuestionsService questionsService){
        this.questionsService = questionsService;
    }



    @GetMapping()
    public List<Question> getQuestionListByTestId(@RequestParam(name = "test_id", required = false) Long id){
        if(id == null || id == 0){
            return questionsService.getQuestions();
        }
        return questionsService.getQuestionListByTestId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id){
        Question question = questionsService.getQuestion(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }
}
