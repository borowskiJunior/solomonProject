package com.solomon.backend.solomonproject.controller.testsession;

import com.solomon.backend.solomonproject.dto.TestSessionDTO;
import com.solomon.backend.solomonproject.service.TestSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class TestSessionControllerImpl implements TestSessionController{
    private final TestSessionService testSessionService;
    private final ConversionService conversionService;

    @Override
    public TestSessionResponse getTestSessionById(Long id) {
        TestSessionDTO testSessionDTO = testSessionService.getTestSessionByTestSessionId(id);

        return conversionService.convert(testSessionDTO, TestSessionResponse.class);
    }

    @Override
    public List<TestSessionResponse> getUserTestSessionList(Long id) {
        List<TestSessionDTO> testSessionDTOList = testSessionService.getListUserTestSessionByUserId(id);

        List<TestSessionResponse> testSessionResponseList = new ArrayList<>();

        for(TestSessionDTO testSessionDTO : testSessionDTOList){
            testSessionResponseList.add(conversionService.convert(testSessionDTO, TestSessionResponse.class));
        }

        return testSessionResponseList;
    }

    @Override
    public TestSessionResponse createTestSession(Long userId, Long testId) {
        TestSessionDTO testSessionDTO = testSessionService.createTestSession(userId, testId);
        return conversionService.convert(testSessionDTO, TestSessionResponse.class);
    }
}
