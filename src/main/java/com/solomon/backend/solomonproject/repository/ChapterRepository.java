package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Max Borowski
 */
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findByCourseId(Long id);
}
