package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Hospital(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
