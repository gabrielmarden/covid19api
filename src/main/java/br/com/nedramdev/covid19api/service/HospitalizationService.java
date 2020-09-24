package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.model.Hospitalization;
import br.com.nedramdev.covid19api.repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Hospitalization> findAll(Integer page, Integer size){ return repository.findAll(PageRequest.of(page,size));}

    public Hospitalization save(Hospitalization hospitalization){
        return repository.save(hospitalization);
    }

    public Page<Hospitalization> findByDisease(String diseaseName, Integer page, Integer size){
        Pageable paging = PageRequest.of(page,size);
        return repository.findByDisease(diseaseName,paging);
    }
}
