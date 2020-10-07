package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
