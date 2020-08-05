package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.model.Exam;
import br.com.nedramdev.covid19api.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamService {

    @Autowired
    private ExamRepository repository;

    public Exam findById(Long id){
        return repository.findById(id).get();
    }

    public List<Exam> findAll(){
        return repository.findAll();
    }

    public Exam save(Exam exam){
        return repository.save(exam);
    }

}
