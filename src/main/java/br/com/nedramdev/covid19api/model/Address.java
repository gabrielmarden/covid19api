package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
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

    public Address() {
    }

    public Address(Long id, String street, Integer number, String neighborhood, String complement) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
