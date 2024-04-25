package com.solomon.backend.solomonproject.controller;

import com.solomon.backend.solomonproject.model.Lesson;
import com.solomon.backend.solomonproject.service.LessonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class LessonsController {
    private final LessonService lessonService;

    public LessonsController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/lesson")
    public List<Lesson> getLessonsByChapterId(@RequestParam(name = "chapter_id", required = false) Long chapterId){
        if(chapterId == null || chapterId == 0){
            return lessonService.getLessons();
        }
        return lessonService.getLessonsByChapterId(chapterId);
    }
}
