package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAnswers();
    Answer getAnswer(Long id);
    void saveAnswer(Answer answer);
    void deleteAnswer(Long id);
}
