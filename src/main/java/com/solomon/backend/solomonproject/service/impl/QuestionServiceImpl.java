package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.repository.QuestionRepository;
import com.solomon.backend.solomonproject.service.QuestionService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionsRepository;
    @Autowired
    public QuestionServiceImpl(QuestionRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public List<Question> getQuestions() {
        return questionsRepository.findAll();
    }
    @Override
    public Question getQuestion(Long id) {
        Optional<Question> foundQuestion = questionsRepository.findById(id);
        return foundQuestion.orElse(null);
    }

    @Override
    @Transactional
    public void saveQuestion(Question question) {
        questionsRepository.save(question);
    }

    @Override
    @Transactional
    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }

    @Transactional
    public List<Answer> getAnswersByQuestionId(Long id){
        Optional<Question> question = questionsRepository.findById(id);
        if(question.isPresent()){
            Hibernate.initialize(question.get().getAnswers());
            if(question.get().getAnswers() == null){
                return Collections.emptyList();
            }
            return question.get().getAnswers();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Question> getQuestionListByTestId(Long id) {
        List<Question> questionList = questionsRepository.findAllByTestId(id);
        if(questionList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There are no questions under this test_id");
        }

        return questionList;
    }
}
