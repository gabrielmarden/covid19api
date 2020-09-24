package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    private Long crm;
    private String name;
    private String speciality;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonIgnore
    private Hospital hospital;
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Diagnostic> diagnostics;

    public Doctor(Long crm, String name, String speciality) {
        this.crm = crm;
        this.name = name;
        this.speciality = speciality;
    }

    public Doctor() {
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @JsonIgnore
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @JsonIgnore
    public List<Diagnostic> getDiagnosis() {
        return diagnostics;
    }

    public void setDiagnosis(List<Diagnostic> diagnostics) {
        this.diagnostics = diagnostics;
    }
}
