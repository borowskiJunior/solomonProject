package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.dto.AnswerDTO;
import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.Lesson;
import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.model.Test;
import com.solomon.backend.solomonproject.repository.LessonRepository;
import com.solomon.backend.solomonproject.repository.QuestionRepository;
import com.solomon.backend.solomonproject.repository.TestRepository;
import com.solomon.backend.solomonproject.service.QuestionService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionsRepository;
    private final LessonRepository lessonRepository;
    private final TestRepository testRepository;
    @Autowired
    public QuestionServiceImpl(QuestionRepository questionsRepository, LessonRepository lessonRepository, TestRepository testRepository) {
        this.questionsRepository = questionsRepository;
        this.lessonRepository = lessonRepository;
        this.testRepository = testRepository;
    }

    @Override
    public List<Question> getQuestions() {
        return questionsRepository.findAll();
    }
    @Override
    public Question getQuestion(Long id) {
        Optional<Question> foundQuestion = questionsRepository.findById(id);
        return foundQuestion.orElse(null);
    }

    @Override
    @Transactional
    public void saveQuestion(Question question) {
        questionsRepository.save(question);
    }

    @Override
    @Transactional
    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }

    //Это наверное не нужный метод
    @Transactional
    public List<Answer> getAnswersByQuestionId(Long id){
        Optional<Question> question = questionsRepository.findById(id);
        if(question.isPresent()){
            Hibernate.initialize(question.get().getAnswers());
            if(question.get().getAnswers() == null){
                return Collections.emptyList();
            }
            return question.get().getAnswers();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Question> getQuestionListByTestId(Long id) {
        List<Question> questionList = questionsRepository.findAllByTestId(id);
        if(questionList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There are no questions under this test_id");
        }

        return questionList;
    }

    @Override
    public List<AnswerDTO> getAnswerList(Long id) {
        Optional<Question> question = questionsRepository.findById(id);
        if(question.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет вопроса по данному question_id");


        List<Answer> answerList = new ArrayList<>(question.get().getAnswers());
        List<AnswerDTO> answerDTOList = new ArrayList<>();

        for (Answer answer : answerList){
            answerDTOList.add(new AnswerDTO(
                    answer.getId(),
                    answer.getAns(),
                    answer.isCorrect()
            ));
        }

        if(answerDTOList.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет ответов к данному вопросу");

        return answerDTOList;
    }


//    @Override
//    public Map<String, List<AnswerDTO>> getQuestionAndAnswerListByTestIdOrLessonId(Long id, String string) {
//        Map<String, List<AnswerDTO>> map = new HashMap<>();
//
//        if(string.equals("lesson")){
//            Optional<Lesson> optionalLesson = lessonRepository.findById(id);
//
//            if(optionalLesson.isEmpty()){
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет урока по данному lesson_id ");
//            }
//
//            Lesson lesson = optionalLesson.get();
//            Test test = lesson.getTest();
//
//            if(test == null){
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет теста у урока по данному lesson_id");
//            }
//
//            Hibernate.initialize(test.getQuestions());
//
////            проверка на наличие вопросов у теста думаю не обязательна
////            if(test.getQuestions().isEmpty()){
////                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Теста у урока по данному lesson_id");
////            }
//
//            for(Question question : test.getQuestions()){
//                List<AnswerDTO> answerDTOList = new ArrayList<>();
//                for (Answer answer : question.getAnswers()){
//                    answerDTOList.add(new AnswerDTO(answer.getId(), answer.getAns(), answer.isCorrect()));
//                }
//                map.put(question.getQuest(), answerDTOList);
//            }
//
//        } else if (string.equals("test")) {
//            Optional<Test> optionalTest = testRepository.findById(id);
//
//            if(optionalTest.isEmpty()){
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нет теста по данному test_id ytn");
//            }
//
//            Test test = optionalTest.get();
//
//            Hibernate.initialize(test.getQuestions());
//
////            проверка на наличие вопросов у теста думаю не обязательна
////            if(test.getQuestions().isEmpty()){
////                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Теста у урока по данному lesson_id");
////            }
//
//            for(Question question : test.getQuestions()){
//                List<AnswerDTO> answerDTOList = new ArrayList<>();
//                for (Answer answer : question.getAnswers()){
//                    answerDTOList.add(new AnswerDTO(answer.getId(), answer.getAns(), answer.isCorrect()));
//                }
//                map.put(question.getQuest(), answerDTOList);
//            }
//
//        }
//
//        return map;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        QuestionServiceImpl that = (QuestionServiceImpl) o;
//        return Objects.equals(questionsRepository, that.questionsRepository) && Objects.equals(lessonRepository, that.lessonRepository);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(questionsRepository, lessonRepository);
//    }
}
