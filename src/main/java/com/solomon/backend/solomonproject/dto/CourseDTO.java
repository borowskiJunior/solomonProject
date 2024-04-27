package com.solomon.backend.solomonproject.dto;


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

    private List<ChapterDTO> chapters;

    public CourseDTO(Long id, String title, String description, String author, Integer price, List<ChapterDTO> chapters) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
        this.chapters = chapters;
    }
}
