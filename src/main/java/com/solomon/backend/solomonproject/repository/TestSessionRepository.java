package com.solomon.backend.solomonproject.repository;
import com.solomon.backend.solomonproject.model.TestSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestSessionRepository extends JpaRepository<TestSession, Long> {
    List<TestSession> findAllByUserId_Id(Long userId);

    //TODO проверть запрос
    @Query("SELECT ts.attemptNumber FROM TestSession ts WHERE ts.userId = :userId AND ts.testId = :testId AND ts.attemptNumber = " +
            "(SELECT MAX(ts2.attemptNumber) FROM TestSession ts2 WHERE ts2.userId = ts.userId AND ts2.testId = ts.testId)")
    Integer findMaxAttemptNumberByUserIdAndTestId(@Param("userId") Long userId, @Param("testId") Long testId);

}
