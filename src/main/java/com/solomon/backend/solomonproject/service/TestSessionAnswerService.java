package com.solomon.backend.solomonproject.service;

import org.springframework.stereotype.Component;

@Component
public interface TestSessionAnswerService {
    Long createTestSessionAnswer(Long testSessionAnswerId, Long answerId);
}
