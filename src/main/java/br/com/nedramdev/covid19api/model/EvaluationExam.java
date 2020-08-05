package br.com.nedramdev.covid19api.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class EvaluationExam {

    @EmbeddedId
    private EvaluationExamPK id;
    private String result;
    private LocalDate collectDate;
    private LocalDate resultDate;

    public EvaluationExam(EvaluationExamPK id, String result, LocalDate collectDate, LocalDate resultDate) {
        this.id = id;
        this.result = result;
        this.collectDate = collectDate;
        this.resultDate = resultDate;
    }

    public EvaluationExamPK getId() {
        return id;
    }

    public void setId(EvaluationExamPK id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDate getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(LocalDate collectDate) {
        this.collectDate = collectDate;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }
}
