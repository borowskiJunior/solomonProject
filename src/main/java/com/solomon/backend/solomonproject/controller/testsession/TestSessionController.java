package com.solomon.backend.solomonproject.controller.testsession;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/test-session")
public interface TestSessionController {
    @GetMapping("/{id}")
    TestSessionResponse getTestSessionById(@PathVariable Long id);

    @GetMapping("/user")
    List<TestSessionResponse> getUserTestSessionList(@RequestParam("user_id") Long userId);

    @PostMapping("/create")
    TestSessionResponse createTestSession (@RequestParam("user_id") Long userId, @RequestParam("test_id") Long testId);
}
