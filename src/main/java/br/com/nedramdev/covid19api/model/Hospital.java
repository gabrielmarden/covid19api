package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID is mandatory")
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    private List<Hospitalization> hospitalizations;
    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    private List<Doctor> doctors;

    public Hospital() {
    }

    public Hospital(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonIgnore
    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    @JsonIgnore
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
