package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Answer_list")
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
    private Question question;

    @OneToMany(mappedBy = "answerId")
    private List<TestSessionAnswer> testSessionAnswer;

    public Answer(String ans, boolean correct) {
        this.ans = ans;
        this.correct = correct;
    }
}
