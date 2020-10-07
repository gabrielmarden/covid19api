package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate entranceDate;
    private LocalDate exitDate;
    private String state;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
    @OneToMany(mappedBy = "id.hospitalization",cascade = CascadeType.ALL)
    private Set<EvaluationExam> evaluationExams;
    @OneToMany(mappedBy = "id.hospitalization",cascade = CascadeType.ALL)
    private Set<Diagnostic> diagnostics;

    public Hospitalization(Long id, LocalDate entranceDate, LocalDate exitDate, String state, Patient patient, Hospital hospital) {
        this.id = id;
        this.entranceDate = entranceDate;
        this.exitDate = exitDate;
        this.state = state;
        this.patient = patient;
        this.hospital = hospital;
    }

}
