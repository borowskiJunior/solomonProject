package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "Test")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Setter
    private String name;

    //мб не Duration
    @Setter
    private Duration runTime;

    @OneToOne()
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

    @OneToMany(mappedBy = "testId")
    private List<Question> questions;

    @OneToMany(mappedBy = "test")
    private List<TestSession> testSessions;

    public Test(String name, Duration runTime) {
        this.name = name;
        this.runTime = runTime;
    }
}
