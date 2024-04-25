package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Chapter;

import java.util.List;

/**
 * @author Max Borowski
 */
public interface ChapterService {
    List<Chapter> getChapters(Long id);
}
