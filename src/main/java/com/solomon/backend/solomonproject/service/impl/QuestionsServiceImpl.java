package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.repository.QuestionsRepository;
import com.solomon.backend.solomonproject.service.QuestionsService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsRepository questionsRepository;
    @Autowired
    public QuestionsServiceImpl(QuestionsRepository questionsRepository) {
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
    public Question saveQuestion(Question question) {
        return questionsRepository.save(question);
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

}
