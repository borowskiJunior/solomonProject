package com.solomon.backend.solomonproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Max Borowski
 */
@Entity
@Table(name = "Person")
@NoArgsConstructor
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private String role;

    public Person(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
