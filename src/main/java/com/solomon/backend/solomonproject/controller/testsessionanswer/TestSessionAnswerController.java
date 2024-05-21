package com.solomon.backend.solomonproject.controller.testsessionanswer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/v1/test-session-answer")
public interface TestSessionAnswerController {
    @PostMapping
    Long createTestSessionAnswer(@RequestParam("test-session-id") Long testSessionId, @RequestParam("answer-id") Long answerId);
}
