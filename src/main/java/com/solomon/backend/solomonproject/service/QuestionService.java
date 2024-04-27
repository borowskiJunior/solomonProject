package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.dto.AnswerDTO;
import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.Question;

import java.util.List;
import java.util.Map;


public interface QuestionService {
    List<Question> getQuestions();
    Question getQuestion(Long id);
    void saveQuestion(Question question);
    void deleteQuestion(Long id);
    List<Answer> getAnswersByQuestionId(Long id);

    //для ани 1
    List<Question> getQuestionListByTestId(Long id);
//    Map<String, List<AnswerDTO>> getQuestionAndAnswerListByTestIdOrLessonId(Long id, String string);

    List<AnswerDTO> getAnswerList(Long id);
}
