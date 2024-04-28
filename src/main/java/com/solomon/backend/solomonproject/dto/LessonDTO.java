package com.solomon.backend.solomonproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LessonDTO {

    private Long id;

    private Integer ordinalNumber;

    private String name;

    private String text;

    private TestDTO test;

    public LessonDTO(Long id, Integer ordinalNumber, String name, String text, TestDTO test) {
        this.id = id;
        this.ordinalNumber = ordinalNumber;
        this.name = name;
        this.text = text;
        this.test = test;
    }
}
