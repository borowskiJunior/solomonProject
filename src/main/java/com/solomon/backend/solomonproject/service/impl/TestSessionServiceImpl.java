package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.dto.TestSessionDTO;
import com.solomon.backend.solomonproject.model.Test;
import com.solomon.backend.solomonproject.model.TestSession;
import com.solomon.backend.solomonproject.model.User;
import com.solomon.backend.solomonproject.repository.TestRepository;
import com.solomon.backend.solomonproject.repository.TestSessionRepository;
import com.solomon.backend.solomonproject.repository.UserRepository;
import com.solomon.backend.solomonproject.service.TestSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestSessionServiceImpl implements TestSessionService {
    private final TestSessionRepository testSessionRepository;
    private final UserRepository userRepository;
    private final TestRepository testRepository;
    private final ConversionService conversionService;

    @Override
    public TestSessionDTO getTestSessionByTestSessionId(Long id) {
        Optional<TestSession> optionalTestSession = testSessionRepository.findById(id);

        if(optionalTestSession.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Test session по данному id не найден");

        TestSession testSession = optionalTestSession.get();

        return TestSessionDTO.builder()
                .id(testSession.getId())
                .userId(testSession.getUserId())
                .test(testSession.getTest())
                .testSessionAnswers(testSession.getTestSessionAnswers())
                .startTime(testSession.getStartTime())
                .finishTime(testSession.getFinishTime())
                .attemptNumber(testSession.getAttemptNumber())
                .build();
    }

    @Override
    public List<TestSessionDTO> getListUserTestSessionByUserId(Long id) {
        Optional<User>  optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User по данному user_id не найден");

        List<TestSession> testSessionList = testSessionRepository.findAllByUserId_Id(id);

        if(testSessionList.isEmpty())
            return Collections.emptyList();

        List<TestSessionDTO> testSessionDTOList = new ArrayList<>();

        for(TestSession t : testSessionList){

            testSessionDTOList.add(
                    TestSessionDTO.builder()
                            .id(t.getId())
                            .userId(t.getUserId())
                            .test(t.getTest())
                            .testSessionAnswers(t.getTestSessionAnswers())
                            .startTime(t.getStartTime())
                            .finishTime(t.getFinishTime())
                            .build()
            );
        }
        return testSessionDTOList;
    }

    @Override
    @Transactional
    public TestSessionDTO createTestSession(Long userId, Long testId) {
        Integer attemptNumber = testSessionRepository.findMaxAttemptNumberByUserIdAndTestId(userId, testId);

        if (attemptNumber == null) {
            attemptNumber = 1;
        } else {
            attemptNumber += 1;
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Test test = testRepository.findById(testId).orElseThrow(() -> new RuntimeException("Test not found"));

        TestSession newTestSession = TestSession.builder()
                .userId(user)
                .test(test)
                .startTime(LocalDateTime.now())
                .attemptNumber(attemptNumber)
                .build();

        testSessionRepository.save(newTestSession);

        return conversionService.convert(newTestSession, TestSessionDTO.class);
    }
}
