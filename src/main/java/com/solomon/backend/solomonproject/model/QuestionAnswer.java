package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "QuestionAnswer")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String text;
    @Setter
    @Column(name = "correct_ans")
    private String correctAns;
    @Setter
    @Column(name = "incorrect_ans_one")
    private String incorrectAnsOne;
    @Setter
    @Column(name = "incorrect_ans_two")
    private String incorrectAnsTwo;
    @Setter
    @Column(name = "incorrect_ans_three")
    private String incorrectAnsThree;
    @Setter
    @Column(name = "incorrect_ans_four")
    private String incorrectAnsFour;
    @Setter
    @Column(name = "incorrect_ans_five")
    private String incorrectAnsFive;
    @Setter
    @Column(name = "incorrect_ans_six")
    private String incorrectAnsSix;
    @Setter
    @Column(name = "incorrect_ans_seven")
    private String incorrectAnsSeven;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    //костыль, надо подумать как по уму это сделать, а может так и делается я хз
    public QuestionAnswer(String text, String correctAns, String incorrectAnsOne, String incorrectAnsTwo, String incorrectAnsThree, String incorrectAnsFour, String incorrectAnsFive, String incorrectAnsSix, String incorrectAnsSeven) {
        this.text = text;
        this.correctAns = correctAns;
        this.incorrectAnsOne = incorrectAnsOne;
        this.incorrectAnsTwo = incorrectAnsTwo;
        this.incorrectAnsThree = incorrectAnsThree;
        this.incorrectAnsFour = incorrectAnsFour;
        this.incorrectAnsFive = incorrectAnsFive;
        this.incorrectAnsSix = incorrectAnsSix;
        this.incorrectAnsSeven = incorrectAnsSeven;
    }
}
