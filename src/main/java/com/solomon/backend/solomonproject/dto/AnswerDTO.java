package com.solomon.backend.solomonproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO {
    private Long id;
    private String quest;
    private boolean correct;

    public AnswerDTO(Long id, String quest, boolean correc) {
        this.id = id;
        this.quest = quest;
        this.correct = correc;
    }

}
