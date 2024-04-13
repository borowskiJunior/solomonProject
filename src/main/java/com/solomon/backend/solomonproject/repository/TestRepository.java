package com.solomon.backend.solomonproject.repository;

import com.solomon.backend.solomonproject.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
