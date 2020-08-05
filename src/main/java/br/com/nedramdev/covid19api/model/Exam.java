package br.com.nedramdev.covid19api.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String description;
    @OneToMany
    private Set<EvaluationExam> evaluationExams;

    public Exam(Long id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EvaluationExam> getEvaluationExams() {
        return evaluationExams;
    }

    public void setEvaluationExams(Set<EvaluationExam> evaluationExams) {
        this.evaluationExams = evaluationExams;
    }
}
