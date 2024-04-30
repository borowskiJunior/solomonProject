package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.dto.TestDTO;
import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.model.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {
    List<Test> getTests();
    Test getTest(Long id);
    void saveTest(Test test);
    void updateTest(Long id, Test updateTest);
    void deleteTest(Long id);
    // для ани 1
    Test getTestByLessonId(Long id);

    TestDTO getAllDataByTestIdOrLessonId(Long id, String string);
}
