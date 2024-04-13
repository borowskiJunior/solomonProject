package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Answer;

import java.util.List;

public interface AnswersService {
    List<Answer> getAnswers();
    Answer getAnswer(Long id);
    Answer saveAnswer(Answer answer);
    void deleteAnswer(Long id);
}
