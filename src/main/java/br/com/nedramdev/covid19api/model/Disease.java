package br.com.nedramdev.covid19api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    private Set<String> symptons;
    @OneToMany
    @JoinColumn(name = "exam_id")
    private List<Exam> exams;
    @OneToMany
    @JsonIgnore
    private Set<Diagnostic> diagnostics;

    public Disease(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Disease() {
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

    public Set<String> getSymptons() {
        return symptons;
    }

    public void setSymptons(Set<String> symptons) {
        this.symptons = symptons;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Set<Diagnostic> getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(Set<Diagnostic> diagnostics) {
        this.diagnostics = diagnostics;
    }


}
