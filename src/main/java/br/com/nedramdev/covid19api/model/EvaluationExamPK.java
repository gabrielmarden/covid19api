package br.com.nedramdev.covid19api.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EvaluationExamPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "hospitalization_id")
    private Hospitalization hospitalization;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public EvaluationExamPK() {
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationExamPK that = (EvaluationExamPK) o;
        return Objects.equals(hospitalization, that.hospitalization) &&
                Objects.equals(exam, that.exam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalization, exam);
    }
}
