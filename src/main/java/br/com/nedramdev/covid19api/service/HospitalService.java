package br.com.nedramdev.covid19api.service;

import br.com.nedramdev.covid19api.exception.ResourceNotFoundException;
import br.com.nedramdev.covid19api.model.Hospital;
import br.com.nedramdev.covid19api.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository repository;

    public Hospital findById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hospital with id "+id+" not found"));
    }

    public List<Hospital> findAll(){
        return repository.findAll();
    }

    public Hospital save(Hospital hospital){
        return repository.save(hospital);
    }
}
