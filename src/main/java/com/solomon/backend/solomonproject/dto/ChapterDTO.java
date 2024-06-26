package com.solomon.backend.solomonproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ChapterDTO {
    private Long id;

    private Integer ordinalNumber;

    private String name;

    private String description;

    private List<LessonDTO> lessons;

    public ChapterDTO(Long id, Integer ordinalNumber, String name, String description, List<LessonDTO> lessons) {
        this.id = id;
        this.ordinalNumber = ordinalNumber;
        this.name = name;
        this.description = description;
        this.lessons = lessons;
    }
}
