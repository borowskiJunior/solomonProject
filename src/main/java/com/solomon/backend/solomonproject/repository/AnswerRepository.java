package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
