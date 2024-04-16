package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Max Borowski
 */
@Entity
@Table(name = "test_session")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Person personId;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    @OneToMany(mappedBy = "testSessionId")
    private List<TestSessionAnswer> testSessionAnswers;

    @Setter
    private LocalDateTime startTime;
    @Setter
    private LocalDateTime finisTime;
    @Setter
    private int attemptNumber;

    public TestSession(LocalDateTime startTime, LocalDateTime finisTime, int attemptNumber) {
        this.startTime = startTime;
        this.finisTime = finisTime;
        this.attemptNumber = attemptNumber;
    }
}
