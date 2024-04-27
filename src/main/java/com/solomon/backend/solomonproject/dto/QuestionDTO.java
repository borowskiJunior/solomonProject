package com.solomon.backend.solomonproject.dto;

import com.solomon.backend.solomonproject.model.Answer;
import com.solomon.backend.solomonproject.model.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class QuestionDTO {
    private Long id;

    private String quest;

    private List<AnswerDTO> answerList;

    public QuestionDTO(Long id, String quest, List<AnswerDTO> answerList) {
        this.id = id;
        this.quest = quest;
        this.answerList = answerList;
    }

}
