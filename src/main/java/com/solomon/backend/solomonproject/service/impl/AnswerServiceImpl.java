package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Answer;

import com.solomon.backend.solomonproject.repository.AnswerRepository;
import com.solomon.backend.solomonproject.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswer(Long id) {
        Optional<Answer> foundAnswer = answerRepository.findById(id);
        return foundAnswer.orElse(null);
    }
    @Transactional
    @Override
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Transactional
    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

}
