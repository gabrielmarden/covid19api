package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "hospitalization_id")
    @JsonIgnore
    private Hospitalization hospitalization;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

}
