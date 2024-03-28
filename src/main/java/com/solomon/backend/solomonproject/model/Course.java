package com.solomon.backend.solomonproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Max Borowski
 */
@Entity
@Table(name = "Course")
@NoArgsConstructor
@Getter
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
    private int price;
    public Course(String title, String description, String author, int price) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
    }
}
