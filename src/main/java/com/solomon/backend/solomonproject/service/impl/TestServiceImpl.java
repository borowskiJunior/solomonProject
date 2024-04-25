package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.model.Test;
import com.solomon.backend.solomonproject.repository.TestRepository;
import com.solomon.backend.solomonproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getTests() {
        return testRepository.findAll();
    }

    @Override
    public Test getTest(Long id) {
        Optional<Test> foundTest = testRepository.findById(id);
        return foundTest.orElse(null);
    }

    @Override
    @Transactional
    public void saveTest(Test test) {
        testRepository.save(test);
    }

    @Override
    @Transactional
    public void updateTest(Long id, Test updateTest) {
        updateTest.setId(id);
        testRepository.save(updateTest);
    }


    @Override
    @Transactional
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public Test getTestByLessonId(Long id) {
        Optional<Test> testByLessonId = testRepository.findByLessonId(id);
        if(testByLessonId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no test for this lesson_id");
        }
        return testByLessonId.get();
    }

}
