package com.solomon.backend.solomonproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Max Borowski
 */
@Entity
@Table(name = "Result")
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private TestSession testSession;

    @Setter
    private int correctResultValue;

    @Setter
    private int personResultValue;

    @Setter
    private float procentCorrectResult;


    public Result(int correctResultValue, int personResultValue) {
        this.correctResultValue = correctResultValue;
        this.personResultValue = personResultValue;
        this.procentCorrectResult = correctResultValue != 0 ? ((float) personResultValue / correctResultValue * 100) : 0;
    }

}
