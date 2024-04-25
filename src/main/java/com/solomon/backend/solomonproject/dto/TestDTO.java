package com.solomon.backend.solomonproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solomon.backend.solomonproject.model.Lesson;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class TestDTO {
    private Long id;

    private String name;

    private Integer runTime;

    private Map<String, List<AnswerDTO>> mapQuestionWithAns;

    public TestDTO(){};
    public TestDTO(Long id, String name, Integer runTime, Map<String, List<AnswerDTO>> mapQuestionWithAns) {
        this.id = id;
        this.name = name;
        this.runTime = runTime;
        this.mapQuestionWithAns = mapQuestionWithAns;
    }
}
