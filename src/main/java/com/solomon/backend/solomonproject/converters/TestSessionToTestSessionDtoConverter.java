package com.solomon.backend.solomonproject.converters;

import com.solomon.backend.solomonproject.dto.TestSessionDTO;
import com.solomon.backend.solomonproject.model.TestSession;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TestSessionToTestSessionDtoConverter implements Converter<TestSession, TestSessionDTO> {

    @Override
    public TestSessionDTO convert(TestSession testSession) {
        if (testSession == null) {
            return null;
        }

        return TestSessionDTO.builder()
                .id(testSession.getId())
                .userId(testSession.getUserId())
                .test(testSession.getTest())
                .testSessionAnswers(testSession.getTestSessionAnswers() != null ?
                        testSession.getTestSessionAnswers().stream().collect(Collectors.toList()) : null)
                .startTime(testSession.getStartTime())
                .finishTime(testSession.getFinishTime())
                .attemptNumber(testSession.getAttemptNumber())
                .build();
    }
}

