package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Lesson")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String ordinalNumber;

    @Setter
    private String name;

    @Setter
    private String text;

    @OneToOne(mappedBy = "lesson")
    @Setter
    @JsonIgnore
    private Test test;

    @ManyToOne
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    @Setter
    @JsonIgnore
    private Chapter chapter;

    public Lesson(String ordinalNumber, String name, String text, Test test, Chapter chapter) {
        this.ordinalNumber = ordinalNumber;
        this.name = name;
        this.text = text;
        this.test = test;
        this.chapter = chapter;
    }
}
