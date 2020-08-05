package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizationService {

    @Autowired
    private HospitalizationRepository repository;

    public Hospitalization findById(Long id){
        return repository.findById(id).get();
    }

    public List<Hospitalization> findAll(){
        return repository.findAll();
    }

    public Hospitalization save(Hospitalization hospitalization){
        return repository.save(hospitalization);
    }
}
