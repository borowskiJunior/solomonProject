package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.TestSession;
import com.solomon.backend.solomonproject.model.TestSessionAnswer;
import com.solomon.backend.solomonproject.repository.AnswerRepository;
import com.solomon.backend.solomonproject.repository.TestSessionAnswerRepository;
import com.solomon.backend.solomonproject.repository.TestSessionRepository;
import com.solomon.backend.solomonproject.service.TestSessionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestSessionAnswerServiceImpl implements TestSessionAnswerService {
    private final TestSessionRepository testSessionRepository;
    private final AnswerRepository answerRepository;
    private final TestSessionAnswerRepository testSessionAnswerRepository;

    @Override
    @Transactional
    public Long createTestSessionAnswer(Long testSessionId, Long answerId) {
        Optional<TestSession> testSession = testSessionRepository.findById(testSessionId);
        Optional<Answer> answer = answerRepository.findById(answerId);

        if(testSession.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Test Session ненайден");

        if(answer.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Answer не найден");

        TestSessionAnswer testSessionAnswer = TestSessionAnswer.builder()
                .testSessionId(testSession.get())
                .answerId(answer.get())
                .build();

        return testSessionAnswerRepository.save(testSessionAnswer).getId();
    }
}
