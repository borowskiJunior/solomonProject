package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Answer")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String ans;

    @Setter
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @Setter
    @JsonIgnore
    private Question question;

    @OneToMany(mappedBy = "answerId")
    @JsonIgnore
    private List<TestSessionAnswer> testSessionAnswer;

    public Answer(String ans, boolean correct, Question question) {
        this.ans = ans;
        this.correct = correct;
        this.question = question;
    }
}
