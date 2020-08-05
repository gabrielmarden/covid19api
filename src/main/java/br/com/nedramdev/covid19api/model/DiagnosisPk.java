package br.com.nedramdev.covid19api.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DiagnosisPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "hospitalization_id")
    private Hospitalization hospitalization;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;


    public DiagnosisPk(Hospitalization hospitalization, Disease disease) {
        this.hospitalization = hospitalization;
        this.disease = disease;
    }

    public DiagnosisPk() {
    }

    public Hospitalization getHospital() {
        return hospitalization;
    }

    public void setHospital(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosisPk that = (DiagnosisPk) o;
        return Objects.equals(hospitalization, that.hospitalization) &&
                Objects.equals(disease, that.disease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalization, disease);
    }
}
