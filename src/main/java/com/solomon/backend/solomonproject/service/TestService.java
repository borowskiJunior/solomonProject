package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Test;

import java.util.List;

public interface TestService {
    List<Test> getTests();
    Test getTest(Long id);
    void saveTest(Test test);
    void updateTest(Long id, Test updateTest);
    void deleteTest(Long id);

}
