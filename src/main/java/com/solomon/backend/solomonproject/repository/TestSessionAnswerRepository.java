package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.TestSessionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSessionAnswerRepository extends JpaRepository<TestSessionAnswer, Long> {
}
