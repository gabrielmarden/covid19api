package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    private String neighborhood;
    private String complement;
    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Patient patient;
    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
