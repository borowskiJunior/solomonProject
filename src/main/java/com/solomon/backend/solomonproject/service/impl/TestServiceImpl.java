package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.dto.TestDTO;
import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.model.Test;
import com.solomon.backend.solomonproject.repository.TestRepository;
import com.solomon.backend.solomonproject.service.QuestionService;
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
    private final QuestionServiceImpl questionService;


    @Autowired
    public TestServiceImpl(TestRepository testRepository, QuestionServiceImpl questionService) {
        this.testRepository = testRepository;
        this.questionService = questionService;
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

    @Override
    public TestDTO getAllDataByTestIdOrLessonId(Long id, String string) {
        TestDTO testDTO;
        if(string.equals("lesson")){
            Optional<Test> optionalTest = testRepository.findByLessonId(id);
            if(optionalTest.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет теста у урока по данному lesson_id");
            }

            Test test = optionalTest.get();
             testDTO = new TestDTO(
                    test.getId(),
                    test.getName(),
                    test.getRunTime(),
                    questionService.getQuestionAndAnswerListByTestIdOrLessonId(id, string)
            );
             return testDTO;

        } else if (string.equals("test")){

            Optional<Test> optionalTest = testRepository.findById(id);
            if(optionalTest.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет теста у урока по данному test_id");
            }

            Test test = optionalTest.get();
            testDTO = new TestDTO(
                    test.getId(),
                    test.getName(),
                    test.getRunTime(),
                    questionService.getQuestionAndAnswerListByTestIdOrLessonId(id, string)
            );
            return testDTO;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
