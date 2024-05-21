package com.solomon.backend.solomonproject.service;
import com.solomon.backend.solomonproject.dto.TestSessionDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestSessionService {
    TestSessionDTO getTestSessionByTestSessionId(Long id);
    List<TestSessionDTO> getListUserTestSessionByUserId(Long id);
    TestSessionDTO createTestSession (Long userId, Long testId);

    //TODO прислать инфу по TestId

}
