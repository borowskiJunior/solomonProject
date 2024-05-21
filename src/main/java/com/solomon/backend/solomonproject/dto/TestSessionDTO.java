package com.solomon.backend.solomonproject.dto;
import com.solomon.backend.solomonproject.model.Test;
import com.solomon.backend.solomonproject.model.TestSessionAnswer;
import com.solomon.backend.solomonproject.model.User;
import lombok.Builder;
import lombok.Value;
import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class TestSessionDTO {
    Long id;

    User userId;

    Test test;

    List<TestSessionAnswer> testSessionAnswers;

    LocalDateTime startTime;

    LocalDateTime finishTime;

    int attemptNumber;
}
