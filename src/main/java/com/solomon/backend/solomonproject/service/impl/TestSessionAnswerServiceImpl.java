package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.TestSessionAnswer;
import com.solomon.backend.solomonproject.service.TestSessionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestSessionAnswerServiceImpl implements TestSessionAnswerService {
    @Override
    public Long createTestSessionAnswer(Long testSessionAnswerId, Long answerId) {
        TestSessionAnswer testSessionAnswer = TestSessionAnswer
        return null;
    }
}
