package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Patient {

    @Id
    @NotNull(message = "CPF is mandatory")
    private Long cpf;
    private String name;
    private String sex;
    private LocalDate birthDate;
    @ElementCollection
    private List<String> phones;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Address> addresses;
    @ManyToMany
    @JoinTable(name="patient_comorbidity",
            joinColumns = @JoinColumn(name="patient_id"),
            inverseJoinColumns = @JoinColumn(name="comorbidity_id")
    )
    private List<Comorbidity> comorbidities;
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Hospitalization> hospitalizations;

    public Patient(Long cpf, String name, String sex, LocalDate birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Comorbidity> getComorbidities() {
        return comorbidities;
    }

    public void setComorbidities(List<Comorbidity> comorbidities) {
        this.comorbidities = comorbidities;
    }

    @JsonIgnore
    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }
}
