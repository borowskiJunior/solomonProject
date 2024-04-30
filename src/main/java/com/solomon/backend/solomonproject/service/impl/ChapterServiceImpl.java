package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Chapter;
import com.solomon.backend.solomonproject.repository.ChapterRepository;
import com.solomon.backend.solomonproject.service.ChapterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * @author Max Borowski
 */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ChapterServiceImpl implements ChapterService {
    private final ChapterRepository chapterRepository;
    @Override
    public List<Chapter> getChapters(Long id) {
        List<Chapter> chapterList = chapterRepository.findByCourseId(id);
        if (chapterList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There are no chapters under this course_id.");
        }
        return chapterList;
    }
}
