package com.solomon.backend.solomonproject.dto;

import com.solomon.backend.solomonproject.model.Test;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LessonDTO {

    private Long id;

    private String ordinalNumber;

    private String name;

    private String text;

    private TestDTO test;

    public LessonDTO(Long id, String ordinalNumber, String name, String text, TestDTO test) {
        this.id = id;
        this.ordinalNumber = ordinalNumber;
        this.name = name;
        this.text = text;
        this.test = test;
    }
}
