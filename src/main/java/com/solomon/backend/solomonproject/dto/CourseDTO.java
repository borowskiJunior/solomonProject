package com.solomon.backend.solomonproject.dto;


import com.solomon.backend.solomonproject.model.Chapter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CourseDTO {
    private Long id;

    private String title;

    private String description;

    private String author;

    private Integer price;

    private List<Chapter> chapters;
}
