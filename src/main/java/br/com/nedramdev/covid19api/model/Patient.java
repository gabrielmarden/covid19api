package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @NotNull
    private String cpf;
    @NotBlank
    private String name;
    @NotBlank
    private String sex;
    private LocalDate birthDate;
    @ElementCollection
    private List<String> phones = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany
    @JoinTable(name="patient_comorbidity",
            joinColumns = @JoinColumn(name="patient_id"),
            inverseJoinColumns = @JoinColumn(name="comorbidity_id")
    )
    private List<Comorbidity> comorbidities = new ArrayList<>();
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Hospitalization> hospitalizations = new ArrayList<>();

    public Patient(String cpf, String name, String sex, LocalDate birthDate) {
        this.cpf = cpf;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

}
