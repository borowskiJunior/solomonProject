package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}
