package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Lesson;
import com.solomon.backend.solomonproject.repository.LessonRepository;
import com.solomon.backend.solomonproject.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    @Override
    public List<Lesson> getLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> getLessonsByChapterId(Long chapterId) {
        List<Lesson> lessons = lessonRepository.findByChapterId(chapterId);
        if(lessons.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There are no lessons under this chapter_id.");
        }
        return lessons;
    }
}
