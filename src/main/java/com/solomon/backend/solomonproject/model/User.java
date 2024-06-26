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
@Table(name = "`user`")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String role;

    @OneToMany(mappedBy = "userId")
    private List<TestSession> testSessions;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserCourse> userCourses;

    //временные поля
    @Setter
    private String login;

    @Setter
    private String password;
    //


    public User(String name, String role, String login, String password) {
        this.name = name;
        this.role = role;
        this.login = login;
        this.password = password;
    }
}
