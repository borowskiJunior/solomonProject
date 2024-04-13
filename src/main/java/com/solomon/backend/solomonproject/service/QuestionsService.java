package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionsService {
    List<Question> getQuestions();
    Question getQuestion(Long id);
    Question saveQuestion(Question question);
    void deleteQuestion(Long id);
    List<Answer> getAnswersByQuestionId(Long id);
}
