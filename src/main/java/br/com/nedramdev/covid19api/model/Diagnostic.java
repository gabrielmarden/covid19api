package br.com.nedramdev.covid19api.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Diagnostic {
    @EmbeddedId
    private DiagnosisPk id;
    private String status;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Diagnostic() {
    }

    public Diagnostic(DiagnosisPk id, String status, LocalDate date) {
        this.id = id;
        this.status = status;
        this.date = date;
    }

    public Diagnostic(Hospitalization hospitalization,Disease disease,String status,LocalDate date){
        this.id = new DiagnosisPk(hospitalization,disease);
        this.status = status;
        this.date = date;
    }


    public DiagnosisPk getId() {
        return id;
    }

    public void setId(DiagnosisPk id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
