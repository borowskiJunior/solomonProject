package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Question_list")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String quest;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    @Setter
    private Test testId;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(String quest) {
        this.quest = quest;
    }
}
