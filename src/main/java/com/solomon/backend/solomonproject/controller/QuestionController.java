package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.dto.AnswerDTO;
import com.solomon.backend.solomonproject.model.Chapter;
import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

//    @GetMapping("/info")
//    public Map<String, List<AnswerDTO>> getQuestionAndAnswerListByTestId(@RequestParam(name = "test_id", required = false) Long testId, @RequestParam(name = "lesson_id", required = false) Long lessonId){
//        if((testId == null || testId == 0) && lessonId != null){
//            return questionService.getQuestionAndAnswerListByTestIdOrLessonId(lessonId, "lesson");
//        } else if (testId != null && (lessonId == null || lessonId == 0 )) {
//            return questionService.getQuestionAndAnswerListByTestIdOrLessonId(testId, "test");
//        }
//        return new HashMap<>();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id){
        Question question = questionService.getQuestion(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }

    @GetMapping("/{id}/answer")
    public List<AnswerDTO> getAnswerListByQuestionId(@PathVariable("id") Long id){

        List<AnswerDTO> answerDTOList = questionService.getAnswerList(id);
        return answerDTOList;
    }
}
