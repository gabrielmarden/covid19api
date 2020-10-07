package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostic {
    @EmbeddedId
    @JsonProperty(value = "details")
    private DiagnosisPk id;
    private String status;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Diagnostic(DiagnosisPk id, String status, LocalDate date) {
        this.id = id;
        this.status = status;
        this.date = date;
    }

    public Diagnostic(Hospitalization hospitalization,Disease disease,String status,LocalDate date){
        this.id = new DiagnosisPk(hospitalization,disease);
        this.status = status;
        this.date = date;
    }

}
