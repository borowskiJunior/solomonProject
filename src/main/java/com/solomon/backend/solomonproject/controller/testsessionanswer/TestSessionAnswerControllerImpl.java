package com.solomon.backend.solomonproject.controller.testsessionanswer;

import com.solomon.backend.solomonproject.service.TestSessionAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestSessionAnswerControllerImpl implements TestSessionAnswerController{
    private final TestSessionAnswerService testSessionAnswerService;
    @Override
    public Long createTestSessionAnswer(Long testSessionId, Long answerId) {
        return testSessionAnswerService.createTestSessionAnswer(testSessionId, answerId);}
}
