package com.solomon.backend.solomonproject.dto;

import com.solomon.backend.solomonproject.model.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TestDTO {
    private Long id;

    private String name;

    private Integer runTime;

    private List<QuestionDTO> questionList;

    public TestDTO(Long id, String name, Integer runTime, List<QuestionDTO> questionList) {
        this.id = id;
        this.name = name;
        this.runTime = runTime;
        this.questionList = questionList;
    }
}
