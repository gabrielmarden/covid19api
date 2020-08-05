package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.model.Disease;
import br.com.nedramdev.covid19api.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepository repository;

    public Disease findById(Long id){
        return repository.findById(id).get();
    }

    public List<Disease> findAll(){
        return repository.findAll();
    }

    public Disease save(Disease disease){ return repository.save(disease);}
}
