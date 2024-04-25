package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Question;
import com.solomon.backend.solomonproject.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByTestId(Long id);
}
