package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Max Borowski
 */
@Entity
@Table(name = "TestSession")
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
    private Person person;

    @OneToMany(mappedBy = "testSession")
    private List<Result> results;

    //кол-во правильных ответов за весь тест
    @Setter
    private int numberOfCorrectAnswers;
    //кол-во неправильных ответов
    @Setter
    private int numberOfIncorrectAnswers;

    public TestSession(Person person, List<Result> results) {
        this.person = person;
        this.results = results;
    }
}
