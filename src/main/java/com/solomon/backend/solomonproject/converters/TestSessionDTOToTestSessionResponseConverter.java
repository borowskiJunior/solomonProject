package com.solomon.backend.solomonproject.converters;

import com.solomon.backend.solomonproject.controller.testsession.TestSessionResponse;
import com.solomon.backend.solomonproject.dto.TestSessionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TestSessionDTOToTestSessionResponseConverter implements Converter<TestSessionDTO, TestSessionResponse> {
    @Override
    public TestSessionResponse convert(TestSessionDTO source) {
        return TestSessionResponse.builder()
                .id(source.getId())
                .userId(source.getUserId().getId())
                .testId(source.getTest().getId())
                .testName(source.getTest().getName())
                .startTime(source.getStartTime())
                .finishTime(source.getFinishTime())
                .attemptNumber(source.getAttemptNumber())
                .build();
    }
}
