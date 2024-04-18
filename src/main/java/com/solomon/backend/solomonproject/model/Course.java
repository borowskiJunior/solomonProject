package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Max Borowski
 */
@Entity
@Table(name = "Course")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String description;

    @Setter
    private String author;

    @Setter
    private Integer price;

    @OneToMany(mappedBy = "course")
    private List<Chapter> chapters;

    @OneToMany(mappedBy = "course")
    private List<UserCourse> userCourses;

    public Course(String title, String description, String author, Integer price) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
    }
}
