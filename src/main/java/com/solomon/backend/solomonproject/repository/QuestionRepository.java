package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByTestId(Long id);

}
