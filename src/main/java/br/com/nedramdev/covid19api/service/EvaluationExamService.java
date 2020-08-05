package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.model.EvaluationExam;
import br.com.nedramdev.covid19api.repository.EvaluationExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationExamService {

    @Autowired
    public EvaluationExamRepository repository;

    public EvaluationExam findById(Long id){
        return repository.findById(id).get();
    }

    public List<EvaluationExam> findAll(){
        return repository.findAll();
    }

    public EvaluationExam save(EvaluationExam evaluationExam){
        return repository.save(evaluationExam);
    }

}
