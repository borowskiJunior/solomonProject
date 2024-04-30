package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Chapter")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private Integer ordinalNumber;

    @Setter
    private String name;

    @Setter
    private String description;

    @OneToMany(mappedBy = "chapter")
    private List<Lesson> lessons;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @Setter
    @JsonIgnore
    private Course course;

    public Chapter(Integer ordinalNumber, String name, String description, Course course) {
        this.ordinalNumber = ordinalNumber;
        this.name = name;
        this.description = description;
        this.course = course;
    }
}
