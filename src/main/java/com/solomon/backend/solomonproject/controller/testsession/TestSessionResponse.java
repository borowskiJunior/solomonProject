package com.solomon.backend.solomonproject.controller.testsession;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class TestSessionResponse {
    private Long id;

    private Long userId;

    private Long testId;

    private String testName;

    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    int attemptNumber;
}
