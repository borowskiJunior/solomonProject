package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getLessons();

    List<Lesson> getLessonsByChapterId(Long chapterId);
}
