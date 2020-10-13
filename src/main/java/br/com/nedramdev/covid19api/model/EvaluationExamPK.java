package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class EvaluationExamPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "hospitalization_id")
    @JsonIgnore
    private Hospitalization hospitalization;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

}
