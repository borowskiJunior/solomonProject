package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test_session_answer")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestSessionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // наверное такое отношение
    @ManyToOne
    @JoinColumn(name = "test_session_id", referencedColumnName = "id")
    @Setter
    private TestSession testSessionId;
    //тут один ко меногим
    @ManyToOne
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    @Setter
    private Answer answerId;

    public TestSessionAnswer(TestSession testSessionId, Answer answerId) {
        this.testSessionId = testSessionId;
        this.answerId = answerId;
    }
}
