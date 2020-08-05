package br.com.nedramdev.covid19api.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String uf;

    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    private List<City> cities;

    public State(Long id, String name, String uf) {
        this.id = id;
        this.name = name;
        this.uf = uf;
    }

    public State() {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
