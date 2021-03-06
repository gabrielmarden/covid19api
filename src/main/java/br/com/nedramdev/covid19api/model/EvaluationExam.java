package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationExam {

    @EmbeddedId
    @JsonProperty(value = "details")
    private EvaluationExamPK id;
    private String result;
    private LocalDate collectDate;
    private LocalDate resultDate;

}
