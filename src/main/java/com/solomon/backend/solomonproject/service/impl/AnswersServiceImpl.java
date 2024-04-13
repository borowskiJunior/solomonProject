package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Answer;

import com.solomon.backend.solomonproject.repository.AnswersRepository;
import com.solomon.backend.solomonproject.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AnswersServiceImpl implements AnswersService {
    private final AnswersRepository answersRepository;

    @Autowired
    public AnswersServiceImpl(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    public List<Answer> getAnswers() {
        return answersRepository.findAll();
    }

    @Override
    public Answer getAnswer(Long id) {
        Optional<Answer> foundAnswer = answersRepository.findById(id);
        return foundAnswer.orElse(null);
    }
    @Transactional
    @Override
    public void saveAnswer(Answer answer) {
        answersRepository.save(answer);
    }

    @Transactional
    @Override
    public void deleteAnswer(Long id) {
        answersRepository.deleteById(id);
    }

}
