package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate entranceDate;
    private LocalDate exitDate;
    private String state;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
    @OneToMany(mappedBy = "id.hospitalization",cascade = CascadeType.ALL)
    private Set<EvaluationExam> evaluationExams;
    @OneToMany(mappedBy = "id.hospitalization",cascade = CascadeType.ALL)
    private Set<Diagnostic> diagnostics;

    public Hospitalization(Long id, LocalDate entranceDate, LocalDate exitDate, String state, Patient patient, Hospital hospital) {
        this.id = id;
        this.entranceDate = entranceDate;
        this.exitDate = exitDate;
        this.state = state;
        this.patient = patient;
        this.hospital = hospital;
    }

    public Hospitalization() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(LocalDate entranceDate) {
        this.entranceDate = entranceDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Diagnostic> getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(Set<Diagnostic> diagnostics) {
        this.diagnostics = diagnostics;
    }

    public Set<EvaluationExam> getEvaluationExams() {
        return evaluationExams;
    }

    public void setEvaluationExams(Set<EvaluationExam> evaluationExams) {
        this.evaluationExams = evaluationExams;
    }
}
