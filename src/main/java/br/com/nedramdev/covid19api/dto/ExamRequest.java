package br.com.nedramdev.covid19api.dto;

import lombok.*;

import java.time.LocalDate;

public class ExamRequest {

    private   Long examId;
    private  Long hospitalizationId;
    private  String resultDetails;
    private  LocalDate collectDate;
    private  LocalDate resultDate;

    public ExamRequest() {
    }

    public ExamRequest(Long examId, Long hospitalizationId, String resultDetails, LocalDate collectDate, LocalDate resultDate) {
        this.examId = examId;
        this.hospitalizationId = hospitalizationId;
        this.resultDetails = resultDetails;
        this.collectDate = collectDate;
        this.resultDate = resultDate;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(Long hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public String getResultDetails() {
        return resultDetails;
    }

    public void setResultDetails(String resultDetails) {
        this.resultDetails = resultDetails;
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
