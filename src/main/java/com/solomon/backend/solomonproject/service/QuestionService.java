package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.Question;

import java.util.List;


public interface QuestionService {
    List<Question> getQuestions();
    Question getQuestion(Long id);
    void saveQuestion(Question question);
    void deleteQuestion(Long id);
    List<Answer> getAnswersByQuestionId(Long id);
}
