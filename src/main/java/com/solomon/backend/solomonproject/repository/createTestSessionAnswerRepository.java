package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.controller.testsessionanswer.TestSessionAnswerController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface createTestSessionAnswerRepository extends JpaRepository<TestSessionAnswerController, Long> {
}
